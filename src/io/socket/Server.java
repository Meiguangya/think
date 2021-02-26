package io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        final int port = 9999;
        ServerSocket serverSocket = null;
        final String quit = "quit";


        try {
            //创建服务器  监听端口
            serverSocket = new ServerSocket(port);
            System.out.println("服务器开启，监听端口：" + port);

            while (true) {
                //阻塞式监听
                Socket socket = serverSocket.accept();
                System.out.println("客户端" + socket.getPort() + "已连接");
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = null;

                while ((msg = reader.readLine()) != null) {
                    System.out.println("客户端说：" + msg);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    if (msg != null) {
                        writer.write(msg + "\n");
                        writer.flush();
                    }
                    if(msg.equals(quit)){
                        System.out.println("客户端"+socket.getPort()+"断开连接");
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    System.out.println("服务端关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
