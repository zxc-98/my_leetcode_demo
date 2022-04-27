package cn.zxc.demo08DynamicPlanning.bag0_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    涉及顺序的完全背包问题  和518的区别和联系
 */
public class CombinationSum4_377 {

    public static void main(String[] args) {
        int[] nums = {9};
        int target = 3;
        System.out.println(combinationSum4_dfs(nums, target));
    }

    public int combinationSum4_dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && i >= nums[j]; j++) {
                dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        return dp[target];
    }


    private static int res = 0;

    private static int combinationSum4_dfs(int[] nums, int target) {
        bfs(nums, target);
        return res;
    }

    private static void bfs(int[] nums, int target) {
        if (target == 0) {
            res++;
            return;
        }

        for (int num : nums) {
            if (target < 0) {
                break;
            }
            bfs(nums, target - num);
        }
    }
}
