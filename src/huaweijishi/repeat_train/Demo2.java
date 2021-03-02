package huaweijishi.repeat_train;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 3
 * 15 8 17
 * 12 20 9
 * 11 7 5
 */
public class Demo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        ArrayList<int[]> resList = new ArrayList<>();
        list.forEach(s -> {
            String[] arr = s.split(" ");
            resList.add(new int[]{
                    Integer.valueOf(arr[0]),
                    Integer.valueOf(arr[1]),
                    Integer.valueOf(arr[2]),
            });
        });

        int[] minIndexArr = new int[n];
        for (int i = 0; i < resList.size(); i++) {
            if (i == 0) {
                minIndexArr[i] = getMinIndex(resList.get(i), -1);
            } else {
                minIndexArr[i] = getMinIndex(resList.get(i), minIndexArr[i - 1]);
            }
        }
        int count = 0;
        for (int j = 0; j < resList.size(); j++) {
            count += resList.get(j)[minIndexArr[j]];
        }
        System.out.println(count);

    }

    public static int getMinIndex(int[] arr, int except) {
        int min = arr[0];
        int index = 0;
        if (except == 0) {
            min = arr[1];
            index = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == except) {
                continue;
            }
            if (arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

}
