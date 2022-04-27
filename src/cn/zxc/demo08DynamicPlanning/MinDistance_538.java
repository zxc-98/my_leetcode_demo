package cn.zxc.demo08DynamicPlanning;

public class MinDistance_538 {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return m + n - 2 * dp[m][n];
    }
}
