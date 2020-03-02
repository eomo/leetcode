package com.hicsc;

public class FibonacciNumber509 {

    public int fib(int N) {
        int[] memo = new int[N + 1];
        return fib(N, memo);
    }

    public int fib(int n, int memo[]) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber509().fib(2));
        System.out.println(new FibonacciNumber509().fib(3));
        System.out.println(new FibonacciNumber509().fib(4));
    }

}
