package io.people_chat;

import io.socket.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String host;
    //自己的端口
    private int port;
    private ServerSocket serverSocket;

    public User(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void send(String msg, String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write(msg);
        writer.flush();
        writer.close();
    }

    public void receive() throws IOException {
        Socket socket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg = null;
        while ((msg = reader.readLine()) != null) {
            System.out.println("编号" + socket.getPort() + ":" + msg);
        }
    }

    /**
     * 与对应主机上的用户通信
     * @param host
     * @param port
     */
    public void start(String host,int port){
        //读取信息线程
        new Thread(() -> {
            while (true) {
                try {
                    this.receive();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //发送信息线程
        new Thread(() -> {
            try {
                //用户控制台输入
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String msg = null;
                    msg = consoleReader.readLine();
                    this.send(msg,host,port);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
