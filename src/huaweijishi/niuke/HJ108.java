package huaweijishi.niuke;

import java.util.Scanner;

/**
 * 正整数A和正整数B 的最小公倍数是指
 * 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 */
public class HJ108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        int num1 = Integer.valueOf(arr[0]);
        int num2 = Integer.valueOf(arr[1]);

        int x = Math.max(num1,num2);
        int y = Math.min(num1,num2);
        int max = x*y;
        if(x%y==0){
            System.out.println(x);
            return;
        }

        while(y!=0){
            int t = x%y;
            x=y;
            y=t;
        }
        //x 最大公约数
        System.out.println(max/x);
    }

}
