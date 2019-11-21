package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        System.out.println("请输入你要创建的数组大小：");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0;
        List<Integer> list = new ArrayList<>();
        System.out.println("请输入数组内容:");
        while (sc.hasNextInt()) {
            if (list.size() == size - 1) {
                list.add(sc.nextInt());
                break;
            } else {
                list.add(sc.nextInt());
            }
        }

        System.out.println("你得到了数组:");
        list.forEach(s -> System.out.print(s + " "));
        sc.close();
    }

}
