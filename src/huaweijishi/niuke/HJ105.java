package huaweijishi.niuke;

import java.math.BigDecimal;
import java.util.Scanner;

public class HJ105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int allCount = 0;
        int sum = 0;
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            if (text.isEmpty()) {
                break;
            }

            int i = Integer.valueOf(text);
            if (i < 0) {
                count++;
            } else {
                sum += i;
            }
            allCount++;
        }

        System.out.println(count);
        if(count==allCount){
            System.out.println(0);
        }else{
            BigDecimal a = new BigDecimal(sum);
            BigDecimal b = new BigDecimal(allCount-count);
            System.out.println(a.divide(b,10,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
    }

}
