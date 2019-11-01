import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution784 {


    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                List<String> listOne = changeList(res, chars[i]);
                //(char) (chars[i] ^ (1 << 5))
                List<String> listTwo = changeList(res, changeChar(chars[i]));
                listOne.addAll(listTwo);
                res = listOne;
            } else {
                res = changeList(res, chars[i]);
            }
        }
        return res;
    }

    public char changeChar(char c) {
        if ('a' <= c && c <= 'z') {
            return Character.toUpperCase(c);
        }else{
            return Character.toLowerCase(c);
        }
    }

    public static List<String> changeList(List<String> list, char add) {
        List<String> temp = new ArrayList<>();
        if (list.size() == 0) {
            temp.add(String.valueOf(add));
        } else {
            list.forEach(s -> {
                temp.add(new StringBuilder(s + add).toString());
            });
        }
        return temp;
    }


    //a1b2
    public static void main(String[] args) {
        Solution784 s = new Solution784();
        List<String> list = s.letterCasePermutation("a1b2");
        list.forEach(str -> {
            System.out.println(str);
        });
    }

}
