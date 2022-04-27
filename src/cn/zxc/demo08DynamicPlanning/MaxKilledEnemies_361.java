package cn.zxc.demo08DynamicPlanning;

public class MaxKilledEnemies_361 {

    public static void main(String[] args) {
        MaxKilledEnemies_361 maxKilledEnemies = new MaxKilledEnemies_361();
        char[][] nums = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println(maxKilledEnemies.maxKilledEnemies(nums));
    }

    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] left = new int[n][m];
        int[][] right = new int[n][m];

        int[][] up = new int[n][m];
        int[][] down = new int[n][m];

        for(int i = 0; i < n; i++) {
            int pre = 0;
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 'W') {
                    pre = 0;
                }
                else if (grid[i][j] == 'E') {
                    pre ++;
                }
                else {
                    left[i][j] = pre;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            int pre = 0;
            for(int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    pre = 0;
                }
                else if (grid[i][j] == 'E') {
                    pre ++;
                }
                else {
                    right[i][j] = pre;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            int pre = 0;
            for(int j = 0; j < n; j++) {
                if (grid[j][i] == 'W') {
                    pre = 0;
                }
                else if (grid[j][i] == 'E') {
                    pre ++;
                }
                else {
                    up[j][i] = pre;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            int pre = 0;
            for(int j = n - 1; j >= 0; j--) {
                if (grid[j][i] == 'W') {
                    pre = 0;
                }
                else if (grid[j][i] == 'E') {
                    pre++;
                }
                else {
                    down[j][i] = pre;
                }
            }
        }

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '0') {
                    dp[i][j] = left[i][j] + right[i][j] + up[i][j] + down[i][j];
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;

    }
}
