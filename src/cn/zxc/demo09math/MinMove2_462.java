package cn.zxc.demo09math;

import java.util.Arrays;

//不是到均值 而是到中位数的距离最小
public class MinMove2_462 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 8, 6};
        System.out.println(minMoves_prefer(nums));
    }


    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int m = 0; //中位数
        if (nums.length % 2 == 1) {
            m = nums[nums.length / 2];
        } else {
            m = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        }

        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - m);
        }

        return res;
    }


    //通过a+m + b-m =a-b
    public static int minMoves_prefer(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;
        int move = 0;
        while (l <= h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }
}
