package io.nio_chatroom;

import java.io.*;

public class UserInputHandler implements Runnable {

    private ChatClient chatClient;

    public UserInputHandler(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String msg = consoleReader.readLine();
                chatClient.send(msg);
                if (chatClient.readToQuit(msg)) {
                    consoleReader.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
