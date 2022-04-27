package cn.zxc.demo08DynamicPlanning;

public class NumberOfArithmeticSlices_413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            if (2 * nums[i - 1] == nums[i] + nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int count = 0;

        for (int p : dp) {
            count += p;
        }
        return count;
    }
}
