package cn.zxc.demo08DynamicPlanning;

public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {
        String text1 = "horse";
        String text2 = "ros";

        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence(text1, text2));
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];//dp的值就是最长公共子序列 初始化 i=0 和 j=0 都是空字符串 结果为0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;//说明两个子字符串的最后一位相等，所以最长公共子序列又增加了 1
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);//比如对于 ace和 bc而言，他们的最长公共子序列的长度等于 ① ace 和 b 的最长公共子序列长度0 与 ② ac 和 bc的最长公共子序列长度1 的最大值，即 1

                }
            }
        }

        return dp[m][n];//我们最终希望求的是 text1 和 text2 的最长公共子序列。所以需要返回的结果是 i = len(text1) 并且 j = len(text2) 时的 dp[len(text1)][len(text2)

    }
}
