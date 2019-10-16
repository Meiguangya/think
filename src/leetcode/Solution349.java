package leetcode;

import java.util.*;

public class Solution349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        intersection(new int[]{1,1,2,2},new int[]{2,2});
    }
}
