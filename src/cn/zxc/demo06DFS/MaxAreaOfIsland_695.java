package cn.zxc.demo06DFS;


public class MaxAreaOfIsland_695 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0,},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }


    private static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j, m, n));
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int x, int y, int m, int n) {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }
        int area = 1;
        grid[x][y] = 0;//**
        for (int[] d : direction) {
            area += dfs(grid, x + d[0], y + d[1], m, n);
        }

        return area;
    }
}
