package cn.zxc.demo05BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumSquare_279 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquare_dp(n));
    }

    //
    private static int numSquare_bfs(int n) {
        List<Integer> squares = genSquare(n);
        Queue<Integer> queue = new LinkedList<>();
        Boolean[] marked = new Boolean[n + 1];
        for (int i = 0; i < n; i++) {
            marked[i] = false;
        }
        marked[n] = true;
        queue.add(n);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            while (size-- > 0) {
                Integer cur = queue.poll();

                for (Integer square : squares) {
                    int next = cur - square;

                    if (next < 0) {
                        break;
                    }

                    if (next == 0) {
                        return level;
                    }

                    if (marked[next]) {//跳过这次增强for循环 防止重复
                        continue;
                    }

                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    //使用动态规划
    private static int numSquare_dp(int n) {
        List<Integer> squares = genSquare(n);

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer square : squares) {
                if (i < square) { //这一步的理解很重要
                    break;
                }
                dp[i] = Math.min(min, dp[i - square] + 1);
            }
        }
        return dp[n];
    }

    //产生小于n的平方数
    private static List<Integer> genSquare(int n) {
        int num = 1;
        int square = 1;
        List<Integer> squares = new ArrayList<>();

        while (square <= n) {
            squares.add(square);
            num++;
            square = num * num;
        }
        return squares;
    }
}
