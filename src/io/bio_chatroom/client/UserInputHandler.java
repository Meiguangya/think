package io.bio_chatroom.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputHandler implements Runnable{

    private ChatClient chatClient;

    public UserInputHandler(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try{
            //读取用户输入，发送到服务器
            while(true){
                BufferedReader consoleReadr = new BufferedReader(new InputStreamReader(System.in));
                String msg = consoleReadr.readLine();
                chatClient.send(msg);
                if(chatClient.readToQuit(msg)){
                    consoleReadr.close();
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
