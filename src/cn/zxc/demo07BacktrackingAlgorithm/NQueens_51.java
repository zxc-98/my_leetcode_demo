package cn.zxc.demo07BacktrackingAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {

    private List<List<String>> solutions;
    private char[][] nQueens;

    private Boolean[] cloUsed;
    private Boolean[] diagonal45Used;
    private Boolean[] diagonal135Used;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        nQueens = new char[n][n];
        solutions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }

        cloUsed = new Boolean[n];
        diagonal45Used = new Boolean[2 * n - 1];
        Arrays.fill(diagonal45Used, false);
        diagonal135Used = new Boolean[2 * n - 1];
        Arrays.fill(diagonal135Used, false);

        this.n = n;
        backtracking(0);
        return solutions;
    }

    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] nQueen : nQueens) {
                list.add(new String(nQueen));
            }
            solutions.add(list);
            return;
        }

        for (int clo = 0; clo < n; clo++) {
            int diagonal45Index = clo + row;
            int diagonal135Index = row - clo;

            if (cloUsed[clo] || diagonal45Used[diagonal45Index] || diagonal135Used[diagonal135Index]) {
                continue;
            }
            nQueens[row][clo] = 'Q';
            cloUsed[clo] = diagonal45Used[diagonal45Index] = diagonal135Used[diagonal135Index] = true;
            backtracking(row + 1);
            cloUsed[clo] = diagonal45Used[diagonal45Index] = diagonal135Used[diagonal135Index] = false;
            nQueens[row][clo] = '.';
        }
    }
}
