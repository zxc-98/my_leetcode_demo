package cn.zxc.demo08DynamicPlanning;

public class WiggleMaxLength_376 {

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(new WiggleMaxLength_376().wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int up = 1, down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
