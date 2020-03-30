package com.hicsc;

/**
 * @author: skye
 * @date: 2020/3/30
 **/
public class LongestIncreasingSubsequence300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lis = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (lis[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            lis[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

//    public static int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int lengthOfLIS = 1;
//        int[] dp = new int[nums.length + 1];
//        for (int i = 0; i < nums.length + 1; i++) {
//            dp[i] = 1;
//        }
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            lengthOfLIS = Math.max(lengthOfLIS, dp[i]);
//        }
//        return lengthOfLIS;
//    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
