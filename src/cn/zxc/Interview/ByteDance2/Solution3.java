package cn.zxc.Interview.ByteDance2;

import java.util.Scanner;

public class Solution3 {

    private static int maxPath = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int l = sc.nextInt();

        int[][] roads = new int[l][l];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j< l; j++) {
                roads[i][j] = sc.nextInt();
            }
        }

        System.out.println(findMaxLoad(roads, max));
    }

    private static int  findMaxLoad(int[][] roads, int max) {
        int path = 0;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] hasVisited = new boolean[roads.length][roads.length];

         return dfs(roads, max, directions, path, 0, 0, hasVisited);
    }
    private static int dfs(int[][] roads, int max, int[][] directions, int path, int i, int j, boolean[][] hasVisited) {

        if( i < 0 || i >= roads.length || j < 0 || j >= roads.length || hasVisited[i][j] ) {
            return 0;
        }

        if (max < roads[i][j]) {
            return 0;
        }

        if (max == 0 && (i == 0 || i == directions.length || j == 0 || j == directions.length)) {
            return path ;
        }

        hasVisited[i][j] = true;

        for(int[] direction : directions) {
            maxPath = Math.max(dfs(roads, max - roads[i][j], directions, path + 1, i + direction[0], j + direction[1], hasVisited),maxPath);
        }

        hasVisited[i][j] = false;
        return maxPath;
    }
}
