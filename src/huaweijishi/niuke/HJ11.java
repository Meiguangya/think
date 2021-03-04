package huaweijishi.niuke;

import java.util.Scanner;

public class HJ11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        System.out.println(sb.reverse().toString());
    }

}
