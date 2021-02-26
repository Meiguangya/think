package io.socket;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {

        final String host = "127.0.0.1";
        final Integer port = 9999;
        final String quit = "quit";

        Socket socket = null;
        BufferedWriter writer = null;

        try {
            socket = new Socket(host, port);
            System.out.println("客户端启动..");
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //读取服务器返回
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //用户控制台输入
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));


            while (true) {
                String msg = consoleReader.readLine();
                writer.write(msg + "\n");
                writer.flush();

                String backMsg = reader.readLine();
                System.out.println("服务器说：" + backMsg);
                if (quit.equals(msg)) {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("socket关闭");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
