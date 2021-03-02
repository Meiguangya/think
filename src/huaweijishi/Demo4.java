package huaweijishi;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo4 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isSuShu(i) && isHuiWen(i)) {
                list.add(i);
            }
        }

        StringBuilder res = new StringBuilder();
        res.append(list.size()+",");
        list.forEach(i->{
            res.append(i+",");
        });
        System.out.println(res.substring(0,res.length()-1));
    }

    public static boolean isSuShu(int n) {
        int a = (int) Math.sqrt(n);
        for (int i = 2; i <= a; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHuiWen(int n) {
        Integer num = Integer.valueOf(n);
        String s1 = num.toString();
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2);
    }


}
