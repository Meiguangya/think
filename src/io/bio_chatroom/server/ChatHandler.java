package io.bio_chatroom.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatHandler implements Runnable {

    private Socket clientSocket;
    private ChatServer chatServer;

    public ChatHandler(ChatServer server, Socket socket) {
        this.chatServer = server;
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            //1.将用户加入聊天室
            chatServer.addClient(clientSocket);
            //2.读取客户端信息 群发到聊天室中
            String msg = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while ((msg = reader.readLine()) != null) {

                String fwdMsg = "客户端"+clientSocket.getPort()+":"+msg;
                System.out.println(fwdMsg);
                chatServer.forwordMsgToRoom(clientSocket,fwdMsg+"\n");

                if (chatServer.readToQuit(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //用户退出群聊
                chatServer.removeFormRoom(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
