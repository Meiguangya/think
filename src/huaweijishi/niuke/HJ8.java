package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HJ8 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = reader.readLine()) != null) {
            int n = Integer.valueOf(str);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String text = reader.readLine();
                String[] arr = text.split(" ");
                int index = Integer.parseInt(arr[0]);
                int num = Integer.parseInt(arr[1]);
                if (map.get(index) != null) {
                    map.put(index, map.get(index) + num);
                } else {
                    map.put(index, num);
                }
            }
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = map.keySet();
            for (Integer i : set) {
                list.add(i);
            }
            list.sort((i1,i2)->{
                return i1-i2;
            });

            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i)+" "+map.get(list.get(i)));
            }

        }
    }

}
