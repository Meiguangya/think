package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Set;

public class HJ45 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            int n = Integer.valueOf(input);
            for(int i=0;i<n;i++){
                input = reader.readLine();
                System.out.println(getMaxNum(input));
            }

        }
    }

    public static int getMaxNum(String str) {
        if (str.isEmpty()) return 0;
        str = str.toLowerCase();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = new Character(str.charAt(i));
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> set = map.keySet();
        int[] nums = new int[set.size()];
        int count = 0;
        for (Character c : set) {
            nums[count] = map.get(c);
            count++;
        }

        //冒泡排序
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        int begin = 26;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res + (begin--) * nums[i];
        }
        return res;
    }

}
