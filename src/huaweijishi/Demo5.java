package huaweijishi;

import java.util.Scanner;

public class Demo5 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int[] encrypNums = getEncrypNum(chars.length);
        for (int i = 0; i < chars.length; i++) {
            char newVal = (char) (chars[i] + encrypNums[i]);
            if (newVal > 'z') {
                int j = ('z' - chars[i]);
                int k = (encrypNums[i] - j) % 26;
                newVal = (char) ('a' + k - 1);
            }
            chars[i] = newVal;
        }
        System.out.println(new String(chars));
    }

    public static int[] getEncrypNum(int n) {
        if (n <= 1 || n >= 50) {
            return null;
        }
        int[] nums = new int[n];
        if (n == 1) {
            nums[0] = 1;
        } else if (n == 2) {
            nums[0] = 1;
            nums[1] = 2;
        } else if (n == 3) {
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 4;
        } else {
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 4;
            for (int i = 3; i < n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
            }
        }
        return nums;
    }

}
