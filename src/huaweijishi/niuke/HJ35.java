package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ35 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            int n = Integer.valueOf(input);
            int[][] res = getArray(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (res[i][j] != 0) {
                        System.out.print(res[i][j] + " ");
                    }
                    if (j == n - 1) System.out.println("");
                }
            }

        }
    }

    public static int[][] getArray(int num) {
        int count = 1;
        int[][] res = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int n = i; n >= 0; n--) {
                res[n][i - n] = count++;
            }
        }
        return res;
    }

}
