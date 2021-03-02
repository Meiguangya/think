package huaweijishi.repeat_train;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String s1 = str.substring(0, str.indexOf('@'));
        String s2 = str.substring(str.indexOf('@') + 1);

        Map<String, Integer> has = new HashMap<>();
        Map<String, Integer> use = new HashMap<>();
        String[] s1Arr = s1.split(",");
        String[] s2Arr = s2.split(",");
        if (s2.isEmpty()) {
            s2Arr = new String[0];
        }

        for (String s : s1Arr) {
            has.put(s.charAt(0) + "", Integer.parseInt(s.charAt(2) + ""));
        }

        for (String s : s2Arr) {
            String k = s.charAt(0) + "";
            Integer v = Integer.parseInt(s.charAt(2) + "");
            Integer have = has.get(k);
            if (have > v) {
                has.put(k, have - v);
            } else if (have < v) {
                use.put(k, v - have);
                has.remove(k);
            } else {
                has.remove(k);
            }
        }

        //拼接结果
        StringBuilder res1 = new StringBuilder();
        for (String s : s1Arr) {
            String k = Character.toString(s.charAt(0));
            if (has.containsKey(k)) {
                res1.append(k + ":" + has.get(k) + ",");
            }
        }
        String r1 = res1.substring(0, res1.length() - 1);
        System.out.println(r1);

        if (s2Arr.length > 0) {
            StringBuilder res2 = new StringBuilder();
            for (String s : s2Arr) {
                String k = Character.toString(s.charAt(0));
                if (use.containsKey(k)) {
                    res2.append(k + ":" + use.get(k) + ",");
                }
            }
            String r2 = res2.substring(0, res2.length() - 1);
            System.out.println(r2);
        }
    }

}
