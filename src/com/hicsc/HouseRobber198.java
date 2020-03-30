package com.hicsc;

/**
 * @author: skye
 * @date: 2020/3/25
 **/
public class HouseRobber198 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

//    public int rob(int[] nums) {
//        int prevMax = 0;
//        int currMax = 0;
//        for (int x : nums) {
//            int temp = currMax;
//            currMax = Math.max(prevMax + x, currMax);
//            prevMax = temp;
//        }
//        return currMax;
//    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber198().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new HouseRobber198().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
