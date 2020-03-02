package com.hicsc;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int one = 2,two = 1,total = 0;
        for (int i = 2; i < n; i++) {
            total = one + two;
            two = one;
            one = total;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(2));
        System.out.println(new ClimbingStairs70().climbStairs(3));
        System.out.println(new ClimbingStairs70().climbStairs(4));
    }
}
