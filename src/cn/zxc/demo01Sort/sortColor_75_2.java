package cn.zxc.demo01Sort;

import java.util.Arrays;

/**
 * 颜色 三元快速切分  因为只有三个数 所以三个指针进行切分
 */
public class sortColor_75_2 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0, 2, 1, 1};
        sortColor(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColor(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;

        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, one++, zero++);
            } else if (nums[one] == 2) {
                swap(nums, one++, two--);
            } else {
                one++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
