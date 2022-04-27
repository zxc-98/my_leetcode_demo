package cn.zxc.demo06DFS;

import java.util.Arrays;

/**
 * 如果有和边界'0'相连的'0' ---> 'T'
 * 其他的'0'就是转成'X'
 */
public class Solve_130 {

    public static void main(String[] args) {
        Solve_130 solve = new Solve_130();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //char[][] board = {{'O'}};
        solve.solve(board);

    }


    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        board[i][j] = 'T';
        for (int[] d : direction) {
            dfs(board, i + d[0], j + d[1], m, n);
        }
    }
}
