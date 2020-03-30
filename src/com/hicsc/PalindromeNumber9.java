package com.hicsc;

/**
 * @author: skye
 * @date: 2020/3/25
 **/
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int s = 0;
        int x1 = x;
        while (x1 > 0) {
            s = s * 10 + x1 % 10;
            x1 = x1 / 10;
        }
        return s == x;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(121));
    }

}
