package com.hicsc;

import java.util.Arrays;

/**
 * @author: skye
 * @date: 2020/3/25
 **/
public class MaximumProductSubarray152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int imax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            } else {
                int temp = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * max);
                max = temp;
            }
            imax = Math.max(imax, max);
        }
        return imax;
    }

//    public int maxProduct(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int[] sub = Arrays.copyOfRange(nums, i, j + 1);
//                int total = 1;
//                for (int k = 0; k < sub.length; k++) {
//                    total = total * sub[k];
//                }
//                max = Math.max(max, total);
//            }
//        }
//        return max;
//    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, -2, 4};
        int[] nums2 = new int[]{-2, 0, -1};
        MaximumProductSubarray152 obj = new MaximumProductSubarray152();
        System.out.println(obj.maxProduct(nums1));
        System.out.println(obj.maxProduct(nums2));
    }

}
