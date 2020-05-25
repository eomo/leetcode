package com.hicsc.string;

public class Problem26 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,1,2};
        removeDuplicates(num1);
        for (int n : num1) {
            System.out.print(n + " ");
        }
        System.out.println();
        int[] num2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(num2);
        for (int n : num2) {
            System.out.print(n + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

}
