package com.hicsc;

/**
 * @author: skye
 * @date: 2020/3/30
 **/
public class RomanToInteger13 {

    public static int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int result = sv(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            if (sv(cs[i]) <= sv(cs[i - 1])) {
                result += sv(cs[i]);
            } else {
                result += sv(cs[i]) - 2 * sv(cs[i-1]);
            }
        }
        return result;
    }

    private static int sv(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
