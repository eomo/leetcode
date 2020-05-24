package com.hicsc.string;

public class Problem11 {

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ?
                    Math.max(maxArea, (j-i) * height[i++]) :
                    Math.max(maxArea,(j-i) * height[j--]);
        }
        return maxArea;
    }


    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i],height[j]);
                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
