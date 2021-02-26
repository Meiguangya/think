package io.bio_chatroom.client;

import io.bio_chatroom.server.ChatServer;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    private final int port = 9999;
    private final String host = "127.0.0.1";
    private String quit = "quit";
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;

    public ChatClient(){

    }

    public boolean readToQuit(String msg){
        return quit.equals(msg);
    }

    public void send(String msg) throws IOException {
        if(!socket.isOutputShutdown()){
            writer.write(msg+"\n");
            writer.flush();
        }
//        if(readToQuit(msg)){
//            writer.close();
//        }
    }

    public String receive() throws IOException {
        String msg = null;
        if(!socket.isInputShutdown()){
            msg = reader.readLine();
        }
        return msg;
    }

    public void close(){
        if(writer!=null){
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        try {
            socket = new Socket(host,port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //用线程处理用户的输入
            new Thread(new UserInputHandler(this)).start();

            //打印服务器的消息
            String msg = null;
            while((msg=receive())!=null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }

}
