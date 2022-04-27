package cn.zxc.demo08DynamicPlanning.bag0_1;

public class FindMaxForm_474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0", "1"};
        System.out.println(new FindMaxForm_474().findMaxForm(strs, 1, 1));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            //背包有两层 第一层放0 第二层放1
            for (int i = m; i >= zeros; i--) { //不满足条件就是超出容量了
                for (int j = n; j >= ones; j--) { //从最大开始装
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);//看看是现在装的多 还是之前没装当前数时装的多
                }
            }
        }
        return dp[m][n];
    }
}
