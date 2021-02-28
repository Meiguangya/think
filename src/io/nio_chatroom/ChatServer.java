package io.nio_chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

public class ChatServer {

    public int port;
    private static final int DEFAULT_PORT = 9999;
    private static String QUIT = "quit";
    private static final int BUFFERSIZE = 1024;

    private ServerSocketChannel server;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFERSIZE);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFERSIZE);

    private Charset charset = Charset.forName("UTF-8");

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            //打开通道
            server = ServerSocketChannel.open();
            //将通道设置为非阻塞
            server.configureBlocking(false);
            //绑定端口进行监听
            server.bind(new InetSocketAddress(port));
            System.out.println("服务器开启，开始监听"+port+"端口");
            //创建Selector 监控Channel
            selector = Selector.open();
            //将服务器的接收事件放入Seletor中进行监听
            server.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                //选择一组其相应通道准备好进行I / O操作的键。
                //这是个阻塞方法 只有在至少选择一个通道之后，才会返回此选择器的wakeup方法，或当前线程中断，以先到者为准
                selector.select();
                //获取当前Selector中发生事件的key
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println("服务器现在有"+selectionKeys.size()+"个channel就绪");
                for (SelectionKey key : selectionKeys) {
                    //处理触发的事件
                    handle(key);
                }
                //清除掉set中的key 防止重复key
                selectionKeys.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handle(SelectionKey key) throws IOException {
        //1.处理客户端连接的channel   accept事件
        if (key.isAcceptable()) {
            //获取客户端的channel
            ServerSocketChannel server = (ServerSocketChannel) key.channel();

            SocketChannel client = server.accept();
            //设置客户端channel为非阻塞
            client.configureBlocking(false);
            //将客户端channel放入selector中，监听read事件
            client.register(selector, SelectionKey.OP_READ);
            //日志
            System.out.println(getClientName(client) + "已连接");
        } else if (key.isReadable()) {
            //2.处理客户端发送消息事件
            SocketChannel client = (SocketChannel) key.channel();
            //获取客户端channel中的信息
            String fwdMsg = recevie(client);
            if (fwdMsg.isEmpty()) {
                //客户端异常,将key 删除掉
                key.cancel();
                //???这个是什么操作
                selector.wakeup();
            } else {
                System.out.println(getClientName(client) + ":" + fwdMsg);
                //分发消息
                forwordMsg(client, fwdMsg);

                //用户退出
                if (readToQuit(fwdMsg)) {
                    key.cancel();
                    selector.wakeup();
                    System.out.println(getClientName(client) + "已退出");
                }
            }
        }

    }

    private String recevie(SocketChannel client) throws IOException {
        readBuffer.clear();
        //从channel中读取数据写入到Buffer中
        while (client.read(readBuffer) > 0) ;
        //将Buffer从写变成读
        readBuffer.flip();
        return String.valueOf(charset.decode(readBuffer));
    }

    public void forwordMsg(SocketChannel client, String msg) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            Channel connectChannel = key.channel();
            if(connectChannel instanceof ServerSocketChannel){
                continue;
            }

            //如果key 还没有取消 并且不是自己的通道 就把信息发送到其他的channel 中去
            if(key.isValid() && !client.equals(connectChannel)){
                writeBuffer.clear();
                //将信息写入Buffer
                writeBuffer.put(charset.encode(getClientName(client)+":"+msg));
                //将Buffer从写入变成读取
                writeBuffer.flip();
                while(writeBuffer.hasRemaining()){
                    ((SocketChannel)connectChannel).write(writeBuffer);
                }
            }
        }
    }

    String getClientName(SocketChannel client) {
        return "客户端[" + client.socket().getPort() + "]";
    }

    public boolean readToQuit(String msg) {
        return QUIT.equals(msg);
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();
    }

}
