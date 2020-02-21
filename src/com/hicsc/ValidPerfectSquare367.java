package com.hicsc;

public class ValidPerfectSquare367 {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == num / mid && num % mid == 0) {
                return true;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare367().isPerfectSquare(104976));
    }

}
