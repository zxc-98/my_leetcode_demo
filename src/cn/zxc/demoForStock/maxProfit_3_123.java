package cn.zxc.demoForStock;

/**
 * 你最多可以完成 两笔 交易 动态规划
 */
public class maxProfit_3_123 {
    public static void main(String[] args) {
        //int[] prices = {7,1,5,3,6,4};
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit2(prices));
    }

    private static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {// 第一次买，收益为负数
                firstBuy = -curPrice;
            }

            if (firstSell < firstBuy + curPrice) { // 第一次卖 ： 当前价格-第一次买入的价格
                firstSell = firstBuy + curPrice;
            }


            if (secondBuy < firstSell - curPrice) { //第二次买 第一次卖出的价格-当前股价
                secondBuy = firstSell - curPrice;
            }

            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }

    private static int maxProfit2(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);

            secondBuy = Math.max(secondBuy, firstSell - curPrice);
            firstSell = Math.max(secondSell, secondBuy + curPrice);

        }
        return secondSell;
    }
}
