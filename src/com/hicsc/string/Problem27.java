package com.hicsc.string;

public class Problem27 {

    public static void main(String[] args) {
        int[] num1 = new int[]{3,2,2,3};
        removeElement(num1,3);
        for (int n : num1) {
            System.out.print(n + " ");
        }
        System.out.println();
        int[] num2 = new int[]{0,1,2,2,3,0,4,2};
        removeElement(num2,2);
        for (int n : num2) {
            System.out.print(n + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
