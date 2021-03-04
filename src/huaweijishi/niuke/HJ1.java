package huaweijishi.niuke;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HJ1 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        char c = (char) in.read();
        int time = 0;
        while (c != '\n') {
            if (c == ' ') {
                time = 0;
            } else {
                time++;
            }
            c = (char) in.read();
        }
        System.out.println(time);
    }

}
