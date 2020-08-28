package leetcode;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {

    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }
        if (digits.length == 1) {
            if (digits[0] + 1 >= 10) {
                return new int[]{1, (digits[0] + 1) % 10};
            } else {
                return new int[]{digits[0] + 1};
            }
        } else {
            if (digits[digits.length - 1] + 1 >= 10) {
                return join2IntArr(plusOne(getPre1Arr(digits)), new int[]{(digits[digits.length - 1] + 1) % 10});
            } else {
                digits[digits.length - 1] = digits[digits.length - 1] + 1;
                return digits;
            }
        }
    }

    private static int[] join2IntArr(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        for (int j = arr1.length; j < arr2.length; j++) {
            res[j] = arr1[j];
        }
        return res;
    }

    private static int[] getPre1Arr(int[] arr) {
        int[] res = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = plusOne(new int[]{1, 2, 9});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
