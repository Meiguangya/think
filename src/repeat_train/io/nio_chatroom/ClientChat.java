package repeat_train.io.nio_chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientChat {

    private String host = "127.0.0.1";
    private int port = 9999;
    private String quit = "quit";

    private SocketChannel client;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private Charset charset = Charset.forName("UTF-8");

    private void start() {
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);
            client.bind(new InetSocketAddress(host, port));

            selector = Selector.open();

            client.register(selector, SelectionKey.OP_CONNECT);
            //new Thread(new UserInputHandler2(client)).start();

            selector.select();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
