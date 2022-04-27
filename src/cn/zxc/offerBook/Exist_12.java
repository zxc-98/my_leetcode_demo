package cn.zxc.offerBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exist_12 {

    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {1, 0}};
    private int m, n;
    private boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        if (word == null) {
            return true;
        }

        if (board == null || board[0].length == 0 || board.length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;

        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isExist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isExist(char[][] board, String word, int k, int i, int j) {
        if (k == word.length()) {
            return true;
        }

        char cur = word.charAt(k);

        if (isVisited[i][j] || i < 0 || i >= m || j < 0 || j >= n || cur != board[i][j]) {//范围判断
            return false;
        }

        isVisited[i][j] = true;

        for (int[] direction : directions) {
            if (isExist(board, word, k + 1, i + direction[0], j + direction[1])) {
                return true;
            }
        }

        isVisited[i][j] = false;
        return false;

    }
}
