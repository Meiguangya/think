package huaweijishi;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc = new Scanner(System.in);
        ArrayList<Integer> minRes = new ArrayList<>();
        while (true) {
            String text = sc.nextLine().trim();
            if ("".equals(text)) {
                break;
            }
            String[] res = text.split(" ");
            int index = getMinIndex(res, minRes);
            minRes.add(index);
        }
        minRes.forEach(a -> System.out.println(a));

    }

    private static int getMinIndex(String[] res, ArrayList<Integer> minRes) {
        int except = -1;
        if (minRes.size() != 0) {
            except = minRes.get(minRes.size() - 1);
        }
        int temp;
        int index;
        if (except == 0) {
            temp = Integer.valueOf(res[1]);
            index = 1;
        } else {
            temp = Integer.valueOf(res[0]);
            index = 0;
        }

        for (int i = 0; i < res.length; i++) {
            if (i == except) {
                continue;
            }
            if (temp >= Integer.valueOf(res[i])) {
                temp = Integer.valueOf(res[i]);
                index = i;
            }
        }
        return index;
    }

}
