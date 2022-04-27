package cn.zxc.demoForStock;

/**
 * 你最多可以完成 两笔 交易 动态规划
 */
public class maxProfit_4_188 {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maxProfit(prices, 5));
    }

    private static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (k >= n / 2) { // 这种情况下该问题退化为普通的股票交易问题
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];//初始化
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);//买入收益
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);//卖出收益
            }
        }
        return dp[k][n - 1];


        /*int buy = Integer.MIN_VALUE , sell = 0 ;

        for (int curPrice : prices) {
            for (int i = 0; i < k; i++) {
                if (buy < sell-curPrice){
                    buy = sell-curPrice;
                }

                if (sell < buy + curPrice){
                    sell = buy + curPrice;
                }
            }
        }
        return sell;*/
    }
}
