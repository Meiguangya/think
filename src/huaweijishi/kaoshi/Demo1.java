package huaweijishi.kaoshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Demo1 {

    public static void main(String[] args) throws IOException {
        System.out.println((char)('z'+25));
        long[] arr = getEncrArr(50);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.exit(0);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = null;
        while((input=reader.readLine())!=null){
            if(input.isEmpty()) break;
            int n = Integer.valueOf(input);
            for(int i=0;i<n;i++){
                input = reader.readLine();
                System.out.println(encryptStr(input));
            }
        }
    }

    public static String encryptStr(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        long[] enryArr = getEncrArr(chars.length);
        for (int i = 0; i < chars.length; i++) {
            char newchar;

            if(chars[i]<'a'||chars[i]>'z') continue;
            int temp = (int)(enryArr[i]%26);

            if (chars[i] + temp > 'z') {
                newchar = (char) ((chars[i] + temp - 'z') % 26 + 'a' - 1);
            } else {
                newchar = (char) (chars[i] + temp);
            }
            chars[i] = newchar;
        }
        return new String(chars);
    }


    public static long[] getEncrArr(int n) {
        long[] arr = new long[n];
        if (n == 1) {
            arr[0] = 1;
        } else if (n == 2) {
            arr[0] = 1;
            arr[1] = 2;
        } else if (n == 3) {
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 4;
        } else {
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 4;
            for (int i = 3; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            }
        }
        return arr;
    }

}
