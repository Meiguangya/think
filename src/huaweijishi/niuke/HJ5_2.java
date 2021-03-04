package huaweijishi.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ5_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            System.out.println(trans0xTo10(sc.nextLine()));
        }
    }


    public static int trans0xTo10(String num) {
        int res = 0;
        int start = 2;
        boolean isNegative = false;
        if (num.charAt(0) == '-') {
            start = 3;
            isNegative = true;
        } else if (num.charAt(0) == '+') {
            start = 3;
        }
        String numStr = num.substring(start, num.length()).toLowerCase();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            res += getIndex((int)(numStr.charAt(i))) * Math.pow(16, numStr.length() - 1 - i);
        }
        if (isNegative) {
            res = -res;
        }
        return res;
    }

    public static int getIndex(int c) {
        if (c >= (int) ('a')) {
            c = 10 + c - (int) ('a');
        } else {
            c = c - (int) ('0');
        }
        return c;
    }

}
