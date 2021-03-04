package huaweijishi.niuke;

import java.util.Scanner;

public class HJ9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=chars.length-1;i>=0;i--){
            if(sb.indexOf(String.valueOf(chars[i]))!=-1){
                continue;
            }
            sb.append(chars[i]);
        }


//        sb.append(input.charAt(input.length() - 1));
//        for (int i = input.length() - 2; i >= 0; i--) {
//            int num = Integer.valueOf(input.substring(i, i + 1));
//            //int lastNum = Integer.valueOf(sb.substring(sb.length() - 1, sb.length()));
//            if (sb.indexOf(num+"") != -1) {
//                continue;
//            } else {
//                sb.append(num);
//            }
//        }

        System.out.println(sb.toString());

    }

}
