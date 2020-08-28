package leetcode;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //两种极端情况
        if(nums2[0]>nums1[m-1]){
            for(int i=0;i<n;i++){
                nums1[m+i]=nums2[i];
            }
        }
        if(nums2[n-1]<nums1[0]){
            for(int i=0;i<m;i++){
                nums1[m+i]=nums1[i];
            }
            for(int j=0;j<n;j++){
                nums1[j]=nums2[j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums2[i]>nums1[j]){
                    continue;
                }else if(nums2[i]<=nums1[j]){

                }
            }
        }


    }

}
