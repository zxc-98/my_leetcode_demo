package cn.zxc.demo02Greedy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
public class MaxSubArray_53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = preSum;
        //贪心思想 如果preSum>0 说明有增益作用 保留preSum 否则舍弃
        //如果全是负数 就寻找负数的最大值
        //从preSum是正数开始
        //preSum从正数变成负数 说明这个区间结束了 返回上面
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
