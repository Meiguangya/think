package niu0822;

import java.util.*;

public class HellloTest {

    public static void main(String[] args) {
        //int n = 3;
        List<String> list = new ArrayList<>();
//        list.add("hello");
//        list.add("helll");
//        list.add("helloo");

        System.out.println("输入N");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while(n!=list.size()){
            if(list.size()==n){
                scanner.close();
                break;
            }
            System.out.println("请输入字符串：");
            String str = scanner.nextLine();
            list.add(str);
        }
        scanner.close();

        System.out.println(list.size());
        list.forEach(s->System.out.println(getRightStr(s)));
        System.out.println("---------");
        list.forEach(s->System.out.println(s));

    }

    public static String getRightStr(String str) {
        boolean f = false;
        String wrongType = judgeWrongType(str);
        String[] strs = wrongType.split("_");
        if ("-1".equals(strs[0])) {
            f = true;
        } else {
            str = fixStrWithType(str, Integer.valueOf(strs[0]), strs[1]);
        }
        if (f) {
            return str;
        } else {
            return getRightStr(str);
        }
    }

    public static String judgeWrongType(String str) {
        String type = "";
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 2) {
                break;
            }
            if (str.charAt(i) != str.charAt(i + 1)) {
                continue;
            }
            if (str.charAt(i) == str.charAt(i + 2)) {
                type = "AAA";
                index = i;
                break;
            } else {
                if (i + 3 <= str.length() - 1 && str.charAt(i + 2) == str.charAt(i + 3)) {
                    type = "AABB";
                    index = i + 2;
                    break;
                } else {
                    continue;
                }

            }
        }
        return index + "_" + type;
    }

    public static String fixStrWithType(String str, int index, String type) {
        StringBuilder sb = new StringBuilder(str);
        if ("AAA".equals(type)) {
            return sb.replace(index, index + 1, "").toString();
        }
        if ("AABB".equals(type)) {
            return sb.replace(index, index + 1, "").toString();
        }
        return str;
    }

}
