package huaweijishi.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        List<Integer> res = new ArrayList<>();
        list.forEach(s -> {
            res.add(trans0xTo10(s));
        });
        res.forEach(s -> {
            System.out.println(s);
        });
    }


    // 1 2 3 4 5 6 7 8 9 a b c d e f 11
    public static int trans0xTo10(String num) {
        int res = 0;
        int start = 2;
        boolean isNegative = false;
        if (num.charAt(0) == '-') {
            start = 3;
        } else if (num.charAt(0) == '+') {
            start = 3;
            isNegative = true;
        }
        String numStr = num.substring(start, num.length()).toLowerCase();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            int x = getIndex(numStr.charAt(i));
            int y = numStr.length() - 1 - i;
            res += x * Math.pow(16, y);
        }
        if (isNegative) {
            res = -res;
        }
        return res;
    }


    public static char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int getIndex(char c) {
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static int getIndex2(char c) {
        int i = (int) c;
        int begin = (int) ('a');
        if (i >= begin) {
            i = 10 + i - begin;
        }
        return i;
    }

}
