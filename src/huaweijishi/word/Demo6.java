package huaweijishi.word;

import java.util.Scanner;

public class Demo6 {

    public static void main(String[] args) {
//        int[] i = new int[]{4, 3, 6, 5, 9, 7, 8};
        //{0,0,0,2,0,5,4}

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] heightStr = text.split(" ");
        int[] height = new int[heightStr.length];
        for (int i = 0; i < heightStr.length; i++) {
            height[i] = Integer.valueOf(heightStr[i]);
        }
        int[] res = new int[n];
        for (int j = res.length - 1; j >= 1; j--) {
            for (int k = j - 1; k >= 0; k--) {
                if (height[k] > height[j]) {
                    res[j] = k;
                    break;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.print(res[i]);
            }else{
                System.out.print(res[i] + " ");
            }
        }
    }

}
