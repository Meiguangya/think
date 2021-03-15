package huaweijishi.niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ37 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = reader.readLine()) != null) {
            if (input.isEmpty()) {
                break;
            }
            System.out.println(getNums(Integer.valueOf(input)));
        }
    }

    public static int getNums(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else if (month == 3) {
            return 2;
        } else {
            return getNums(month - 1) + getNums(month - 2);
        }
    }

}
