package cn.zxc.offerBook;

public class LastRemaining_62 {
    public static void main(String[] args) {
        LastRemaining_62 lastRemaining = new LastRemaining_62();
        System.out.println(lastRemaining.lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }

        return dp[n];
    }
}
