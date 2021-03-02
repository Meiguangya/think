package huaweijishi.repeat_train;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime(i)&&isHuiwen(i)){
               list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()+",");
        list.forEach((s)->{
            sb.append(s+",");
        });
        System.out.println(sb.substring(0,sb.length()-1));

    }

    public static boolean isPrime(int n) {
        int x = (int) Math.sqrt(n);
        for (int i = 2; i <= x; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHuiwen(int n) {
        String s1 = new StringBuilder(n + "").reverse().toString();
        String s2 = n + "";
        return s1.equals(s2);
    }

}
