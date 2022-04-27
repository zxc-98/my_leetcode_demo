package cn.zxc.demo08DynamicPlanning;

public class HouseRobber_198 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new HouseRobber_198().rob_dp(nums));

    }

    public int rob(int[] nums) {
        // dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        int pre1 = 0, pre2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }

    public int rob_dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
