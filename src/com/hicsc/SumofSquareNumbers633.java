package com.hicsc;

public class SumofSquareNumbers633 {

    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumofSquareNumbers633().judgeSquareSum(2));
    }

}
