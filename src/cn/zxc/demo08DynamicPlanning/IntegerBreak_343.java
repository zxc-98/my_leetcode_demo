package cn.zxc.demo08DynamicPlanning;

public class IntegerBreak_343 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new IntegerBreak_343().integerBreak(n));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //第一个max得到的是第i个数的最大拆分值
                //当i= 10 时：
                //j*dp[i-j]=4*dp[6]=4*(9) 和 j*(i-j)=4*6=24 之间的比较
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));//
            }
        }

        return dp[n];
    }
}
