package cn.zxc.Interview.ByteDance1;
import java.util.*;
public class Solution_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] soldiers = new int[k][2];
        for(int i = 0; i < k; i++){
            soldiers[i][0] = sc.nextInt();
            soldiers[i][1] = sc.nextInt();
        }

        Set<Integer> change = new HashSet<>();
        for(int i = 0; i < k; i++){
            change.add(i);
        }
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int xt = sc.nextInt();
        int yt = sc.nextInt();

        int minStep = Integer.MAX_VALUE;
        dfs(n, m, soldiers, new boolean[n][m], minStep, x0, y0, xt, yt, 0, change);
        if (minStep == Integer.MAX_VALUE) minStep = -1;
        System.out.println(minStep);
    }

    private static void dfs(int n, int m, int[][] soldiers, boolean[][] hasVisited, int minStep, int x0, int y0, int xt, int yt, int step, Set<Integer> change) {

        if (step > minStep) return;

        if(x0 == xt && y0 == yt) {
            minStep = Math.min(minStep,step);
            return;
        }

        if(x0 < 0 || x0 >= n || y0 < 0 || y0 >= m || hasVisited[x0][y0]){
            return;
        }

        hasVisited[x0][y0] = true;
        if (check(soldiers,x0+1,y0+1)){
            for (int i = 0; i < soldiers.length; i++){
                if (soldiers[i][0] == x0 + 1 && soldiers[i][1] == y0 + 1){
                    change.remove(i);
                }
            }
            dfs(n, m, soldiers, new boolean[n][m], minStep, x0+2, y0+2, xt, yt, step+1, change);
        }

        if (check(soldiers,x0-1,y0+1)){
            for (int i = 0; i < soldiers.length; i++){
                if (soldiers[i][0] == x0 - 1 && soldiers[i][1] == y0 + 1){
                    change.remove(i);
                }
            }
            dfs(n, m, soldiers, new boolean[n][m], minStep, x0-2, y0+2, xt, yt, step+1, change);
        }

        if (check(soldiers,x0+1,y0-1)){
            for (int i = 0; i < soldiers.length; i++){
                if (soldiers[i][0] == x0 + 1 && soldiers[i][1] == y0 - 1){
                    change.remove(i);
                }
            }
            dfs(n, m, soldiers, new boolean[n][m], minStep, x0+2, y0-2, xt, yt, step+1, change);
        }

        if (check(soldiers,x0-1,y0-1)){
            for (int i = 0; i < soldiers.length; i++){
                if (soldiers[i][0] == x0 - 1 && soldiers[i][1] == y0 - 1){
                    change.remove(i);
                }
            }
            dfs(n, m, soldiers, new boolean[n][m], minStep, x0-2, y0-2, xt, yt, step+1, change);
        }

        hasVisited[x0][y0] = false;
    }

    private static boolean check(int[][] soldiers, int x, int y) {
        for (int[] soldier : soldiers) {
            if (soldier[0] == x && soldier[1] == y) {
                return false;
            }
        }
        return true;
    }


}
