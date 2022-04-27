package cn.zxc.demo06DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 从海岸线沿岸出发
 * 关于同时标记太平洋和大西洋 从海岸线出发可以减轻问题复杂度
 */
public class PacificAtlantic_417 {
    public static void main(String[] args) {
        PacificAtlantic_417 PacificAtlantic = new PacificAtlantic_417();
        int[][] height = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(PacificAtlantic.pacificAtlantic(height));
    }


    private int m, n;
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        Boolean[][] canReachP = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                canReachP[i][j] = false;
            }
        }
        Boolean[][] canReachA = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                canReachA[i][j] = false;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, canReachA);
            dfs(heights, i, n - 1, canReachP);
        }

        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, canReachA);
            dfs(heights, m - 1, i, canReachP);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    res.add(r);
                }
            }
        }
        return res;
    }

    /**
     * 满足条件 就标记true 否则continue
     *
     * @param heights
     * @param i
     * @param j
     * @param canReach
     */
    private void dfs(int[][] heights, int i, int j, Boolean[][] canReach) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;
        for (int[] d : direction) {
            if (i + d[0] < 0 || i + d[0] >= m || j + d[1] < 0 || j + d[1] >= n || heights[i][j] > heights[i + d[0]][j + d[1]]) {
                continue;
            }
            dfs(heights, i + d[0], j + d[1], canReach);
        }
    }


}
