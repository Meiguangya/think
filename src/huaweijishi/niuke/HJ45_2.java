package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;

public class HJ45_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            int n = Integer.valueOf(input);
            for (int i = 0; i < n; i++) {
                input = reader.readLine();
                System.out.println(getMaxNum(input));
            }

        }
    }

    public static int getMaxNum(String str) {
        int[] nums = new int[26];
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nums[(chars[i]-'a')]++;
        }
        Arrays.sort(nums);
        int res = 0;
        int max = 26;
        for(int i=25;i>=0;i--){
            if(nums[i]==0) continue;
            res +=(max--)*nums[i];
        }
        return res;
    }

}
