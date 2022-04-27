package cn.zxc.demo08DynamicPlanning.bag0_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//完全背包问题 和377相比不涉及顺序
public class CoinChange2_518 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(coinChange2_dp(coins, amount));
    }


    private static int coinChange2_dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    private static int res = 0;

    private static int coinChange2_bfs(int[] coins, int amount) {
        bfs(coins, amount, 0);
        return res;
    }

    private static void bfs(int[] coins, int amount, int start) {
        if (amount == 0) {
            res++;
            return;
        }

        for (int i = start; i < coins.length; i++) {
            if (amount < 0) {
                break;
            }
            bfs(coins, amount - coins[i], i);
        }
    }
}
