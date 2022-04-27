package cn.zxc.demo03BinarySearch;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 */
public class SearchRange_34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) {
            return ret;
        }
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (target > nums[m]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        if (target == nums[l]) {
            int index = l;
            for (int i = l + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    index++;
                }
            }
            ret[0] = l;
            ret[1] = index;
            return ret;
        }
        return ret;
    }
}
