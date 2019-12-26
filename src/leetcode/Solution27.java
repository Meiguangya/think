package leetcode;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution27 {


    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        for (; i < len; i++) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
                i--;
            }
        }
        return len;
    }

    //[3,2,2,3]

    // [0,1,2,2,3,0,4,2]
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s.charAt(0));
    }


}
