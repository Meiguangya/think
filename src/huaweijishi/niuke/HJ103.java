package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ103 {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int n = Integer.valueOf(str);
            int[] nums = new int[n];
            String input = reader.readLine();
            String[] arr = input.split(" ");
            for(int i=0;i<n;i++){
                nums[i] = Integer.valueOf(arr[i]);
            }
            System.out.println(getMax(nums));
        }

    }

    static int getMax(int[] n) {
        int res = -1;
        int[] dp = new int[n.length];
        dp[0] = 1;
        for (int i = 1; i < n.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (n[j] < n[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }

        return res;
    }


}
