package cn.zxc.demo02Greedy;

public class CheckPossibility_665 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    private static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] >= 0) {
                continue;
            }
            count++;
            // 判断变动之后是否满足条件 nums[i-2] 很重要 ？ 根据前两个数判断是变 前一个数nums[i-1]还是当前数nums[i]？
            if (i >= 2 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
