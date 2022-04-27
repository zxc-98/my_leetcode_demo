package cn.zxc.demo08DynamicPlanning.bag0_1;

public class FindTargetSumWays_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new FindTargetSumWays_494().findTargetSumWays_dp(nums, target));
    }


    private int ways = 0;

    public int findTargetSumWays_dfs1(int[] nums, int target) {
        findWays(nums, 0, target, 0);
        return ways;
    }

    private void findWays(int[] nums, int i, int target, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                ways++;
            }
            return;
        }

        sum -= nums[i];
        findWays(nums, i + 1, target, sum);
        sum += nums[i];

        sum += nums[i];
        findWays(nums, i + 1, target, sum);
        sum -= nums[i];
    }


    public int findTargetSumWays_dp(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
            return 0;
        }

        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[w];
    }


    public int findTargetSumWays_dfs2(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int start, int target) {
        if (start == nums.length) {
            return target == 0 ? 1 : 0;
        }

        return dfs(nums, start + 1, target - nums[start]) + dfs(nums, start + 1, target - nums[start]);
    }
}
