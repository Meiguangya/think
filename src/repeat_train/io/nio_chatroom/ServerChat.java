package repeat_train.io.nio_chatroom;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class ServerChat {

    private int port=9999;
    private String quit="quit";
    private int bufferSize=1024;

    private ServerSocketChannel server;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(bufferSize);
    private ByteBuffer writeBuffer;
    private Charset charset = Charset.forName("UTF-8");

    public void start(){
        try {
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(port));
            server.configureBlocking(false);
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);

            while(true){
                selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    handle(key);
                }
                keys.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(selector);
        }
    }

    public void handle(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
            //客户端连接上来
            SocketChannel client = (SocketChannel) key.channel();
            System.out.println(getClientName(key)+"连接上来了");
            client.configureBlocking(false);
            client.register(selector,SelectionKey.OP_READ);
        }else if(key.isReadable()){
            String msg = getMsg(key);
            if(msg.isEmpty()){
                //客户端出错
                key.cancel();
                selector.wakeup();
            }else{
                forwordMsg(key,msg);
            }

            if(readToQuit(msg)){
                key.cancel();
                System.out.println(getClientName(key));
            }
        }
    }

    private void forwordMsg(SelectionKey key, String msg) throws IOException {
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey connectKey : keys) {
            if(connectKey.channel() instanceof ServerSocketChannel){
                continue;
            }
            if(connectKey!=key){
                sendMsg(connectKey,msg);
            }
        }
    }

    private void sendMsg(SelectionKey connectKey, String msg) throws IOException {
        writeBuffer.clear();
        writeBuffer.put(charset.encode(msg));
        writeBuffer.flip();
        SocketChannel client = (SocketChannel) connectKey.channel();
        while(writeBuffer.hasRemaining()){
            client.write(writeBuffer);
        }
    }

    private boolean readToQuit(String msg) {
        return quit.equals(msg);
    }

    public String getClientName(SelectionKey key){
        SocketChannel client = (SocketChannel) key.channel();
        if(client!=null){
            return  "客户端["+client.socket().getPort()+"]";
        }
        return null;
    }

    public String getMsg(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        String msg = "";
        if(key.isValid() && client!=null){
            readBuffer.clear();
            client.read(readBuffer);
            readBuffer.flip();
            msg = String.valueOf(charset.decode(readBuffer));
        }
        return msg;
    }

    public void close(Closeable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
