package com.hicsc;

import java.util.Arrays;

/**
 * @author: skye
 * @date: 2020/3/30
 **/
public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
            return result.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
