package huaweijishi.word;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 4 10
 * 1 1
 * 2 1
 * 3 1
 * 4 -2
 */
public class Demo7 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int n = Integer.valueOf(text.split(" ")[0]);
        int e = Integer.valueOf(text.split(" ")[1]);
        sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            text = sc.nextLine();
            if (text.isEmpty()) {
                break;
            }
            int k = Integer.valueOf(text.split(" ")[0]);
            int v = Integer.valueOf(text.split(" ")[1]);
            map.put(k, v);
        }
        int height = 0;
        if (map.containsKey(0)) {
            height = map.get(0);
        }
        BigDecimal area = new BigDecimal(0);
        for (int x = 1; x <= e; x++) {
            area = area.add(new BigDecimal(height));
            if (map.containsKey(x)) {
                height += map.get(x);
            }
        }

        System.out.println(area);

    }

}
