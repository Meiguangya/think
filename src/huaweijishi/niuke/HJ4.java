package huaweijishi.niuke;

import java.util.Scanner;

public class HJ4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            StringBuilder text = new StringBuilder(sc.nextLine());
            if (text.toString().isEmpty()) break;
            if (text.length() <= 8) {
                int count = 8 - text.length();
                for (int i = 0; i < count; i++) {
                    text.append("0");
                }
                System.out.println(text.toString());
            } else {
                int time = (text.length() % 8) == 0 ? (text.length() / 8) : (text.length() / 8 + 1);
                for (int i = 0; i < time; i++) {
                    String temp = text.substring(i * 8, (i * 8 + 8) > text.length() ? text.length() : (i * 8 + 8));
                    if (temp.length() == 8) {
                        System.out.println(temp);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < 8 - temp.length(); j++) {
                            sb.append("0");
                        }
                        System.out.println(temp + sb.toString());
                    }
                }
            }
        }

    }

}
