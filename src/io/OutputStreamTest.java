package io;

import java.io.*;
import java.text.SimpleDateFormat;

public class OutputStreamTest {

    public static void main(String[] args) {
        File f = new File("d.txt");
        try {
            FileWriter fo = new FileWriter(f);
            fo.write("123");
            fo.write("456");
            fo.flush();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
