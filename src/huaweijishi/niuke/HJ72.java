package huaweijishi.niuke;

import java.util.ArrayList;
import java.util.Scanner;

public class HJ72 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        ArrayList<int[]> res = getResult();
        for (int[] arr : res) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]*3);
        }
    }

    private static ArrayList<int[]> getResult() {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            int sum = 5 * i;
            for (int j = 0; j <= (100 - 5 * i) / 3; j++) {
                sum = 3 * j + 5 * i;
                for (int k = 0; k <= (100 - 5 * i - 3 * j); k++) {
                    sum = 3 * j + 5 * i + k;
                    if (sum == 100 && (i+j+k*3)==100) {
                        int[] type = new int[3];
                        type[0] = i;
                        type[1] = j;
                        type[2] = k;
                        list.add(type);
                        continue;
                    }
                }
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

}
