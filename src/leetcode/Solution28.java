package leetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution28 {


    public static int strStr(String haystack, String needle) {
        if("".equals(haystack)||"".equals(needle)){
            return 0;
        }
        int i = 0;
        int hlen = haystack.length(), nlen = needle.length();
        for (; i < hlen - nlen; i++) {
            for (int j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == nlen - 1) {
                    return i;
                } else {
                    continue;
                }
            }
        }
        return -1;
    }

    //[3,2,2,3]

    // [0,1,2,2,3,0,4,2]
    public static void main(String[] args) {
        "String".indexOf("St");
        System.out.println(strStr("",""));
    }


}
