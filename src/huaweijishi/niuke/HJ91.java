package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ91 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = null;
        while ((text = reader.readLine()) != null) {
            if (text.isEmpty()) break;
            String[] arr = text.split(" ");
            int n = Integer.valueOf(arr[0]);
            int m = Integer.valueOf(arr[1]);
            System.out.println(getNum(n, m));
        }
    }

    static int getNum(int n, int m) {
        int[][] arr = new int[n][m];
        arr[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[n - 1][m - 1];
    }


}
