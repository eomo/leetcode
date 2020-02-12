package com.hicsc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ValidSudoku36 {

    public boolean isValidSudoku(char[][] board) {
        // 判断每一行的数字是否合法(是否有重复数字)
        if (!isValidRow(board)) {
            return false;
        }
        // 判断每一列的数字是否合法(是否有重复数字)
        if (!isValidCol(board)) {
            return false;
        }
        // 判断每个九宫格的数字是否合法
        if (!isValidNine(board)) {
            return false;
        }
        return true;
    }

    public boolean isValidNine(char[][] board) {
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                int[] array = new int[10];
                for (int x = 0; x < 3; x ++) {
                    for (int k = 0; k < 3; k++) {
                        if (board[i + x][j + k] != '.') {
                            array[board[i + x][j + k] - '0']++;
                        }
                    }
                }
                for (int count : array) {
                    if (count > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *  判断每一行的数字是否合法(是否有重复数字)
     */
    public boolean isValidRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] array = new int[10];
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    array[board[i][j] - '0']++;
                }
            }
            for (int count : array) {
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  判断每一列的数字是否合法(是否有重复数字)
     */
    public boolean isValidCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] array = new int[10];
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] != '.') {
                    array[board[j][i] - '0']++;
                }
            }
            for (int count : array) {
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
