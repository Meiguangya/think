package huaweijishi.niuke;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class HJ7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        int x = (int) num;
        if (num - x >= 0.5) {
            num = x + 1;
        } else {
            num = x;
        }
        System.out.println((int)num);
    }
}
