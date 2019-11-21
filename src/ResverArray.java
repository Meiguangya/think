import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小Q定义了一种数列称为翻转数列:
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 */
//323445962 371
public class ResverArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0, m = 0;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        }

        if (sc.hasNextInt()) {
            m = sc.nextInt();
        }
        sc.close();

        //- + - + ....
        List<Integer> list = new ArrayList<>();
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                int temp = -i;
                num += temp;
                continue;
            }
            int temp;
            if (i % m == 0) {
                if (i / m % 2 == 1) {
                    temp = -i;
                } else {
                    temp = i;
                }
            } else {
                if (i / m % 2 == 0) {
                    temp = -i;
                } else {
                    temp = i;
                }
            }
            num += temp;
        }

        System.out.println(num);
    }
}
