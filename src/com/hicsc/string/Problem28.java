package com.hicsc.string;

public class Problem28 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issipi"));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        for (;;) {
            if (j == needle.length()) {
                return i - j;
            }
            if (i - j > haystack.length() - needle.length()) {
                break;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
