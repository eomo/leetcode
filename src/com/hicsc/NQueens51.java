package com.hicsc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NQueens51 {

    // 皇后的攻击范围
    Set<Integer> attacks = new HashSet<>();
    Set<Integer> pieAttacks = new HashSet<>();
    Set<Integer> naAttacks = new HashSet<>();
    Map<Integer, Integer> currentQueen = new HashMap<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<List<Integer>> queens = new ArrayList<>();
        DFS(n, 0, queens);
        return genQueenString(queens, n);
    }

    /**
     * @param n            N皇后问题
     * @param row          遍历到哪一行来啦
     * @param queens       最后的结果
     * @param currentQueen 当前结果(当前的合法的解法)
     */
    public void DFS(int n, int row, List<List<Integer>> queens) {
        // 如果遍历的行数已经大于总行数,那么说明当前的解法是合法的
        if (row == n) {
            queens.add(new ArrayList<>(currentQueen.values()));
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

            DFS(n, row + 1, queens);

            attacks.remove(col);
            pieAttacks.remove(row + col);
            naAttacks.remove(row - col);
        }
    }

    public List<List<String>> genQueenString(List<List<Integer>> positions, int n) {
        List<List<String>> queens = new ArrayList<>();
        for (List<Integer> position : positions) {
            List<String> queen = new ArrayList<>();
            for (int index : position) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == index ? "Q" : ".");
                }
                queen.add(sb.toString());
            }
            queens.add(queen);
        }
        return queens;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> queens = new NQueens51().solveNQueens(n);
//        for (List<String> col : queens) {
//            for (String line : col) {
//                System.out.println(line + ",");
//            }
//            System.out.println("------------------");
//        }
    }
}
