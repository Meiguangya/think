package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * <p>
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 */
public class HJ61 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        while ((text = reader.readLine()) != null) {
            if(text.isEmpty()) break;
            String[] arr = text.split(" ");
            System.out.println(getNums(Integer.valueOf(arr[0]), Integer.valueOf(arr[1])));
        }
    }

    //m个苹果 n个盘子
    static int getNums(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0 || n == 1 || m == 1) {
            return 1;
        }
        //有一个空盘 + 每个盘子至少放一个
        return getNums(m, n - 1) + getNums(m - n, n);
    }

}
