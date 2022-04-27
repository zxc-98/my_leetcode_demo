package cn.zxc.demo08DynamicPlanning;

public class MinSteps_650 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(minSteps(n));
    }

    public static int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                for (int j = i - 1; j > 0; j--) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + i / j;
                        break;
                    }
                }
            } else {
                dp[i] = dp[i / 2] + 2;
            }
        }
        return dp[n];
    }
}
