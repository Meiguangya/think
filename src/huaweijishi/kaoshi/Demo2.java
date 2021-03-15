package huaweijishi.kaoshi;

import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getStr(n));
    }

    public static String getStr(int n) {
        if (n == 0) {
            return "1";
        } else if (n == 1) {
            return "11";
        } else {
            return transfor(getStr(n - 1));
        }
    }

    public static String transfor(String str) {
        StringBuilder sb = new StringBuilder();
        String temp = str.substring(0, 1);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (temp.equals(str.substring(i, i + 1))) {
                count++;
            } else {
                sb.append(count + temp);
                temp = str.substring(i, i + 1);
                i--;
                count = 0;
            }
        }
        sb.append(count + temp);
        return sb.toString();
    }

}
