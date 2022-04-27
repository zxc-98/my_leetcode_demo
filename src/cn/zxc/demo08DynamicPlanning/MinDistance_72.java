package cn.zxc.demo08DynamicPlanning;

public class MinDistance_72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];//dp的值代表最小操作次数
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;//word1==null 需要全增加操作
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;//word2==null 需要全删除操作
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];//字符相等 不需要操作
                } else {
                    //增，dp[i][j] = dp[i][j - 1] + 1
                    //删，dp[i][j] = dp[i - 1][j] + 1
                    //改，dp[i][j] = dp[i - 1][j - 1] + 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;//
                }
            }
        }
        return dp[m][n];
    }
}
