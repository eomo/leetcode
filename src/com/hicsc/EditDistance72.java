package com.hicsc;

import java.util.Arrays;

/**
 * @author: skye
 * @date: 2020/4/3
 **/
public class EditDistance72 {

    public static int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        for (int i = 0; i <= cs1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= cs2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                if (cs1[i-1] == cs2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
