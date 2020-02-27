package com.hicsc.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch212 {

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        for (String word : words) {
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(word, board, visited, "", i, j);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(String word, char[][] board, boolean[][] visited, String str, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        str += board[x][y];
        if (!word.startsWith(str)) {
            return;
        }
        if (word.equals(str)) {
            res.add(str);
            return;
        }
        visited[x][y] = true;
        dfs(word, board, visited, str, x - 1, y);
        dfs(word, board, visited, str, x + 1, y);
        dfs(word, board, visited, str, x, y - 1);
        dfs(word, board, visited, str, x, y + 1);
        visited[x][y] = false;
    }


    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearch212().findWords(board, words));
    }
}
