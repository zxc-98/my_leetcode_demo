package cn.zxc.demo02Greedy;

/**
 * 贪心 判断递增数的个数
 */
public class maxProfit_2_122 {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}
