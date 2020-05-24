package com.hicsc.string;

import java.util.Arrays;

public class Problem16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int val = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - val)) {
                    val = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return val;
                }
            }
        }
        return val;
    }
}
