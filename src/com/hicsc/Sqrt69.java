package com.hicsc;

public class Sqrt69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt69().mySqrt(Integer.MAX_VALUE));
    }
}
