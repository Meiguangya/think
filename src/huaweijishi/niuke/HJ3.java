package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            boolean[] stus = new boolean[1000];
            StringBuilder sb = new StringBuilder();
            int n = Integer.valueOf(str);
            for (int i = 0; i < n; i++) {
                stus[Integer.valueOf(reader.readLine())] = true;
            }
            for (int i = 0; i < stus.length; i++) {
                if (stus[i]) {
                    sb.append(i + "\n");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

}
