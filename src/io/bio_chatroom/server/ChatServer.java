package io.bio_chatroom.server;

import io.socket.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private final int port = 9999;
    private ServerSocket serverSocket;
    private String quit = "quit";
    private Map<Integer, Writer> chatRoom;
    private ExecutorService executorService;

    //构造方法
    public ChatServer() {
        chatRoom = new HashMap<>();
        executorService = Executors.newFixedThreadPool(200);
    }

    /**
     * 添加客户端到聊天室
     *
     * @param socket
     */
    public void addClient(Socket socket) throws IOException {
        if (socket != null) {
            int port = socket.getPort();
            chatRoom.put(port, new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            System.out.println("客户端" + socket.getPort() + "已连接到服务器");
        }
    }

    /**
     * 移除客户端到聊天室
     *
     * @param socket
     */
    public synchronized void removeFormRoom(Socket socket) throws IOException {
        if (socket != null) {
            int port = socket.getPort();
            if (chatRoom.containsKey(port)) {
                chatRoom.get(port).close();
                chatRoom.remove(port);
            }
        }
    }

    /**
     * 将信息发给聊天室的其他人
     *
     * @param msg
     */
    public synchronized void forwordMsgToRoom(Socket socket, String msg) throws IOException {
        for (Integer port : chatRoom.keySet()) {
            if (port != socket.getPort()) {
                Writer writer = chatRoom.get(port);
                writer.write(msg);
                writer.flush();
            }
        }
    }

    /**
     * 判断客户端是否退出
     * @param msg
     * @return
     */
    public boolean readToQuit(String msg) {
        return quit.equals(msg);
    }

    /**
     * 关闭服务端
     */
    public void close() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("聊天服务器启动，开始监听" + port + "端口");

            while (true) {
                Socket socket = serverSocket.accept();
                //启动用于处理用户消息接收和群发线程
                //new Thread(new ChatHandler(this, socket)).start();
                executorService.execute(new ChatHandler(this,socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }


}
