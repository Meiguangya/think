package io.nio_chatroom;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class ChatClient {

    private int port = 9999;
    private String host = "127.0.0.1";
    private String quit = "quit";

    private SocketChannel client;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private Charset charset = Charset.forName("UTF-8");

    public void start() {
        try {
            //开启通道
            client = SocketChannel.open();
            //设置为不阻塞
            client.configureBlocking(false);

            selector = Selector.open();
            //注册connect事件
            client.register(selector, SelectionKey.OP_CONNECT);
            //将通道与服务端连接
            client.connect(new InetSocketAddress(host, port));

            while (true) {
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    handle(key);
                }
                keys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClosedSelectorException e) {
            // 用户正常退出
        } finally {
            close(selector);
        }
    }

    public void handle(SelectionKey key) throws IOException {
        if (key.isConnectable()) {
            SocketChannel client = (SocketChannel) key.channel();
            if (client.isConnectionPending()) {
                client.finishConnect();
                //如果通道连接上了
                //启动线程 阻塞用户输入的操作
                new Thread(new UserInputHandler(this)).start();
            }
            //并将channel 放入read监听
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            String msg = recevice(client);
            if (msg.isEmpty()) {
                //服务器异常
                System.out.println("服务器异常");
                close(selector);
            } else {
                System.out.println(msg);
            }
        }
    }

    public String recevice(SocketChannel client) throws IOException {
        readBuffer.clear();
        while (client.read(readBuffer) > 0) ;
        readBuffer.flip();
        return String.valueOf(charset.decode(readBuffer));
    }

    public void send(String msg) throws IOException {
        writeBuffer.clear();
        writeBuffer.put(charset.encode(msg));
        writeBuffer.flip();
        while (writeBuffer.hasRemaining()) {
            client.write(writeBuffer);
        }
        if (readToQuit(msg)) {
            close(selector);
        }
    }

    public boolean readToQuit(String msg) {
        return quit.equals(msg);
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }

}
