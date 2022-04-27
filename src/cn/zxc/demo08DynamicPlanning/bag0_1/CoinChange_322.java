package cn.zxc.demo08DynamicPlanning.bag0_1;

import java.util.LinkedList;
import java.util.Queue;

//完全背包问题
public class CoinChange_322 {
    public static void main(String[] args) {
        int[] coin = {1, 2, 3};
        int amount = 6;

        System.out.println(new CoinChange_322().coinChange_dp(coin, amount));
    }

    //深度太高时间太长
    public int coinChange_bfs(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        int level = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                Integer p = queue.poll();

                if (p == 0) {
                    return level;
                }
                if (p < 0) {
                    continue;
                }

                for (int coin : coins) {
                    queue.add(p - coin);
                }
            }
        }

        return -1;
    }

    public int coinChange_dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
