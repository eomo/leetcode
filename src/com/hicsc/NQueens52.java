package com.hicsc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NQueens52 {

    // 皇后的攻击范围
    Set<Integer> attacks = new HashSet<>();
    Set<Integer> pieAttacks = new HashSet<>();
    Set<Integer> naAttacks = new HashSet<>();
    Map<Integer, Integer> currentQueen = new HashMap<>();
    int count = 0;

    public int solveNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        DFS(n, 0);
        return count;
    }

    /**
     * @param n            N皇后问题
     * @param row          遍历到哪一行来啦
     * @param queens       最后的结果
     * @param currentQueen 当前结果(当前的合法的解法)
     */
    public void DFS(int n, int row) {
        // 如果遍历的行数已经大于总行数,那么说明当前的解法是合法的
        if (row == n) {
            count++;
            return;
        }
        // 对于每一行来说，先从每一行的第一列开始，直到最后一列
        // 如果当前列有合法的解法，那么继续进入下一行
        // 如果当前列没有合法的解法，则进入下一列，直到这一行截止为止
        for (int col = 0; col < n; col++) {
            if (attacks.contains(col) || pieAttacks.contains(row + col) || naAttacks.contains(row - col)) {
                continue;
            }

            attacks.add(col);
            pieAttacks.add(row + col);
            naAttacks.add(row - col);

            currentQueen.put(row, col);

            DFS(n, row + 1);

            attacks.remove(col);
            pieAttacks.remove(row + col);
            naAttacks.remove(row - col);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new NQueens52().solveNQueens(n));
    }
}
