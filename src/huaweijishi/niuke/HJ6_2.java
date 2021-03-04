package huaweijishi.niuke;

import java.util.Scanner;

public class HJ6_2 {

    /**
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 最后一个数后面也要有空格
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                sb.append(i + " ");
                n /= i;
                i--;
                continue;
            }
        }
        sb.append(n);
        System.out.println(sb.toString());

    }

//    private static void addZhiShuNum(Long num, ArrayList<Long> list, ArrayList<Long> primes) {
//        if (num == 1) {
//            return;
//        }
//        if (isPrime(num)) {
//            list.add(num);
//            return;
//        }
//        for (int i = 0; i < primes.size(); i++) {
//            if (num % primes.get(i) == 0) {
//                list.add(primes.get(i));
//                num = num / primes.get(i);
//                break;
//            }
//        }
//        addZhiShuNum(num, list, primes);
//    }

//    private static boolean isPrime(long num) {
//        long x = (long) Math.sqrt(num);
//        for (int i = 2; i <= x; i++) {
//            if (num % i == 0) return false;
//        }
//        return true;
//    }

}
