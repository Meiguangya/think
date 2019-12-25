package io;

import java.io.*;

public class InputStreamTest {

    public static void main(String[] args) {
        File file = new File("a.txt");
        System.out.println(file.getAbsolutePath());
        //读操作
        //1.字节
//        try {
//            InputStream in = new FileInputStream(file);
//            OutputStream out = new FileOutputStream("b.txt");
//            byte[] bts = new byte[1024];
//            int i = 0;
//            while ((i = in.read(bts)) != -1) {
//                out.write(bts, 0, i);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //字符流
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            BufferedWriter out = new BufferedWriter(new FileWriter("c.txt"));

            String temp = null;
            while ((temp = in.readLine()) != null) {
                if ("".equals(temp.trim())) {
                    continue;
                }
                out.write(temp + "\n");
                out.newLine();
            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
