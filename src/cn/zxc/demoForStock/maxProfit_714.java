package cn.zxc.demoForStock;

/**
 * 含手续费的股票
 */
public class maxProfit_714 {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit_better(prices, 2));
    }

    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];

        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(s2[i - 1], sell[i - 1]) - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            sell[i] = Math.max(s1[i], buy[i]) + prices[i] - fee;
            s2[i] = Math.max(sell[i - 1], s2[i - 1]);
        }
        return Math.max(s2[n - 1], sell[n - 1]);
    }

    private static int maxProfit_better(int[] prices, int fee) {
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

}
