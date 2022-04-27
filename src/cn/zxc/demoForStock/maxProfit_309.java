package cn.zxc.demoForStock;

/**
 * 含有冷冻期的股票
 */
public class maxProfit_309 {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {1, 2, 1, 4, 5};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];

        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);//持股还是卖出
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
            s2[i] = Math.max(sell[i - 1], s2[i - 1]);//冷却期
        }
        return Math.max(s2[n - 1], sell[n - 1]);
    }


}
