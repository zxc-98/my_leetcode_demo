package cn.zxc.demo06DFS;

public class ShortestBridge_934 {

    public static void main(String[] args) {
        int[][] A = {{0,1,0},{0,0,0}, {0,0,1}};
        System.out.println(new ShortestBridge_934().shortestBridge(A));
    }

    private int n;
    private int m;
    public int shortestBridge(int[][] grid) {
       int ret = 0;
       n = grid.length;
       m = grid[0].length;

       for(int i = 0; i < n; i++) {
           for(int j = 0; j < m; j++) {
               if (grid[i][j] == 1) {
                   dfs(grid, i, j);
                   while (!bfs(grid)) {
                       ret++;
                   }
                   return ret;
               }
           }
       }
       return -1;
    }

    private boolean bfs(int[][] grid) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] != 2) {
                    continue;
                }
                if (color(grid, i - 1, j) || color(grid, i + 1, j) || color(grid, i, j + 1) || color(grid, i , j - 1)) {
                    return true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
        return false;
    }

    private boolean color(int[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        }

        if (grid[i][j] == 0) {
            grid[i][j] = 3;
        }

        return false;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i , j - 1);
    }


}
