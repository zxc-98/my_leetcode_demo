package cn.zxc.demo08DynamicPlanning.bag0_1;

public class CanPartition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        System.out.println(new CanPartition().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = computeArraysSum(nums);
        if (sum % 2 != 0) {
            return false;
        }

        int w = sum / 2;
        boolean[] dp = new boolean[w + 1];//dp表示结果 w表示背包的重量
        dp[0] = true;

        for (int num : nums) {//相当于物品的重量
            for (int i = w; i >= num; i--) { //背包的容积大于物体
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[w];
    }

    private int computeArraysSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


}
