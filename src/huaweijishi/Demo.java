package huaweijishi;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空字符串s和一个包含非空单词列表的字典wordDict,
 * 判定s是否可以被拆成一个或多个在字典中出现的单词，
 * 比如输入s="leetcode", wordDict=["leet", "code"],
 * 则返回true;
 * 如果输入"leettcode"， 则返回false
 */
public class Demo {

    public static void main(String[] args) {
        String finalStr = "catsappledogdog";

        String[] strArr = new String[]{"cat","sapple", "edog"};
        List<String> list = new ArrayList<>();

        for (int j = 0; j < strArr.length; j++) {
            String str = finalStr;
            String temp = strArr[strArr.length-1];
            strArr[strArr.length-1] = strArr[0];
            strArr[0] = temp;
            for (int i = 0; i < strArr.length; ) {
                if (str.indexOf(strArr[i]) == -1) {
                    if (i == strArr.length - 1) break;
                    i++;
                    continue;
                }
                str = str.replaceFirst(strArr[i], "");
                i = 0;
            }
            list.add(str);
        }
        boolean res = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length()==0){
                res = true; break;
            }
        }
        System.out.println(res);
    }


}
