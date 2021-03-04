package io.people_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeoPleB {

    public static void main(String[] args) throws IOException {
        User u = new User("127.0.0.1",10002);
        u.start("127.0.0.1",10001);
    }

}
