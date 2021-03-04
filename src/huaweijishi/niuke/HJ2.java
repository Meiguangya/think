package huaweijishi.niuke;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        char c = '1';
        int count = 0;
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            if (text.isEmpty()) {
                break;
            }
            if (count == 0) {
                str = text.toLowerCase();
            } else if (count == 1) {
                c = text.toLowerCase().charAt(0);
            }
            count++;
        }

        count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.println(count);
    }

}
