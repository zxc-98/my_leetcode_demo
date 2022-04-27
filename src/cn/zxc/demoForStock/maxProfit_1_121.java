package cn.zxc.demoForStock;

/**
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 假如计划在第 i 天卖出股票，那么最大利润的差值一定是在[0, i-1] 之间选最低点买入；所以遍历数组，依次求每个卖出时机的的最大差值，再从中取最大值
 */
public class maxProfit_1_121 {
    public static void main(String[] args) {
        int[] prices = {2, 5, 1, 3};
        System.out.println(maxProfit_diff(prices));
    }

    private static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            /*if (minPrice>prices[i]){
                minPrice=prices[i];//寻找最低点的价格
            }else {
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);//
            }*/
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    private static int maxProfit_diff(int[] prices) {
        int[] diff = new int[prices.length];

        for(int i = 1; i < prices.length; i++) {
            diff[i] = prices[i] - prices[i-1];
        }

        int curPrice = diff[0];
        int maxP = diff[0];

        for(int i = 1; i < diff.length; i++) {
            curPrice = Math.max(curPrice + diff[i], diff[i]);
            maxP = Math.max(maxP, curPrice);
        }

        return maxP;
    }
}
