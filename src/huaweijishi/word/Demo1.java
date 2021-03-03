package huaweijishi.word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {

//        String s1 = "123456";
//        System.out.println(s1.substring(0, 2));
//        System.out.println(s1.indexOf('3'));
//        System.out.println(s1.substring(s1.indexOf('3') + 1, s1.length()));

        start();

    }

    //a:3,b:5,c:3@a:1,b:2,c:3
    public static void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str = reader.readLine();
            String all = str.substring(0, str.indexOf('@'));
            String use = str.substring(str.indexOf('@') + 1, str.length());


            String[] allArr = all.split(",");
            String[] useArr = use.split(",");
            if("".equals(use)){
                useArr = new String[]{};
            }
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> canUsered = new HashMap<>();
            for (String a : allArr) {
                map.put(a.substring(0, 1), Integer.valueOf(a.substring(2, 3)));
            }
            for (String b : useArr) {
                String key = b.substring(0, 1);
                int val = map.get(key);
                int userNum = Integer.valueOf(b.substring(2, 3));
                if (userNum > val) {
                    canUsered.put(key, userNum - val);
                    map.remove(key);
                } else if (userNum < val) {
                    map.put(key, val - userNum);
                } else {
                    map.remove(key);
                }
            }

            StringBuilder releasrStr = new StringBuilder();
            for (String a : allArr) {
                String key = a.substring(0,1);
                if (map.containsKey(key)) {
                    releasrStr.append(key + ":" + map.get(key) + ",");
                }
            }

            StringBuilder cantUserStr = new StringBuilder();
            for (String u : useArr) {
                String key = u.substring(0,1);
                if (canUsered.containsKey(key)) {
                    cantUserStr.append(key + ":" + canUsered.get(key) + ",");
                }
            }

            if (releasrStr.length() > 0) {
                System.out.println(releasrStr.substring(0, releasrStr.length()-1));
            }

            if (cantUserStr.length() > 0) {
                System.out.println(cantUserStr.substring(0, cantUserStr.length()-1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
