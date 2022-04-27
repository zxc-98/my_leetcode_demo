package cn.zxc.demo08DynamicPlanning;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(new ClimbingStairs_70().climbStairs_dfs(n));
    }

    public int climbStairs(int n) {

        if (n < 2) {
            return n;
        }


        int pre1 = 2; //台阶2
        int pre2 = 1; //台阶1

        //台阶3
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }

    public int climbStairs_dp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairs_dfs(int n) {
        return dfs(n, 0, 1, 0);
    }

    private int dfs(int n, int a, int b, int start) {
        if (start == n - 1) {
            return b;
        }
        int c = a + b;
        return dfs(n, b, c % 1000000007, start + 1);
    }

}
