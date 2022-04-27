package cn.zxc.demo06DFS;


public class NumIsland_200 {
    public static void main(String[] args) {
        NumIsland_200 numIsland = new NumIsland_200();
        //int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0,},
        //        {0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        char[][] grid = {{'1', '1', '1', '1', '0'}};
        System.out.println(numIsland.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, i, j, m, n);
                count++;
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1], m, n);
        }

    }
}





