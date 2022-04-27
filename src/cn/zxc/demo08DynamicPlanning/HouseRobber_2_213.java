package cn.zxc.demo08DynamicPlanning;

public class HouseRobber_2_213 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new HouseRobber_2_213().HouseRob(nums));

    }

    public int HouseRob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        //第一间房子和最后一间房子不能一起偷
        return Math.max(rob(nums, 1, n - 1), rob(nums, 0, n - 2));
    }

    private int rob(int[] nums, int first, int end) {
        // dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        int pre1 = 0, pre2 = 0;

        for (int i = first; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }


}
