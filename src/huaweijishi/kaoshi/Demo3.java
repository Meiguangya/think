package huaweijishi.kaoshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo3 {

    private final static String finalStr = "aeiouAEIOU";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input=reader.readLine())!=null){
            if(input.isEmpty()) break;

            int n = new Integer(input);
            input = reader.readLine();
            System.out.println(getStr(n,input));
        }

        reader.close();
    }

    public static int getStr(int n, String str) {
        int res = 0;
        for (int i = 0, j = str.length() - 1; i <= j; ) {
            if (finalStr.indexOf(str.charAt(i)) == -1) {
                i++;
                j = str.length()-1;
                continue;
            }
            if (finalStr.indexOf(str.charAt(j)) == -1) {
                j--;
                continue;
            }
            if(j-i+1<n){
                return 0;
            }
            int num = getXC(str.substring(i, j + 1));
            if (num == n) {

                res = j - i + 1;
                return res;
            } else {
                i++;
                j = str.length()-1;
            }
        }
        return res;
    }

    //获取瑕疵数
    public static int getXC(String string) {
        int res = 0;
        for (int i = 0; i < string.length(); i++) {
            if (finalStr.indexOf(string.charAt(i)) == -1) {
                res++;
            }
        }
        return res;
    }

}
