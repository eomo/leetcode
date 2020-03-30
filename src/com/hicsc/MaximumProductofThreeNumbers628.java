package com.hicsc;

import java.util.Arrays;

/**
 * @author: skye
 * @date: 2020/3/25
 **/
public class MaximumProductofThreeNumbers628 {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length <= 3) {
            return sum(nums);
        }
        // 找到3个正数最大值
        // 找到3个负数最小值
        Arrays.sort(nums);

        int a = nums[0] * nums[1] * nums[nums.length - 1];
        int b = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];

        // 比较：两个最小负数 * 最大正数 ? 三个最大正数
        return Math.max(a, b);
    }

    public int sum(int[] nums) {
        int total = 0;
        for (int x : nums) {
            total *= x;
        }
        return total;
    }

    public static void main(String[] args) {
        MaximumProductofThreeNumbers628 obj = new MaximumProductofThreeNumbers628();
        System.out.println(obj.maximumProduct(new int[]{1,2,3}));
        System.out.println(obj.maximumProduct(new int[]{1,2,3,4}));
    }
}
