package leetcode;

public class Solution5 {

    //babad
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int maxLen = 0;
        int begin = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = s.lastIndexOf(s.charAt(i));
            if (lastIndex == i) {
                continue;
            }
            if (lastIndex - i + 1 > maxLen && isPalindrome(s.substring(i, lastIndex + 1))) {
                maxLen = lastIndex - i + 1;
                begin = i;
                end = lastIndex;
            }
        }

        return s.substring(begin, end + 1);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution5 s = new Solution5();
//        System.out.println(s.isPalindrome("abba"));
//        System.out.println("abba".lastIndexOf('a'));
//        System.out.println("abba".substring(0,3));
        System.out.println(s.longestPalindrome("aaabaaaa"));
    }
}
