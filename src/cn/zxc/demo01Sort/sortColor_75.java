package cn.zxc.demo01Sort;

import java.util.Arrays;

/**
 * 颜色 三元快速切分  快速排序 慢方法
 */
public class sortColor_75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        setColor(nums);
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums);
    }

    private static void setColor(int[] nums) {
        int end = nums.length - 1;
        qSort(nums, 0, end);
    }

    private static void qSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = getIndex(nums, start, end);

            qSort(nums, start, index - 1);
            qSort(nums, index + 1, end);
        }
    }

    private static int getIndex(int[] nums, int start, int end) {
        int temp = end;
        swap(nums, start, temp);

        int index = start;
        int pivot = nums[start];

        for (int i = start + 1; i <= end; i++) {
            if (pivot >= nums[i]) {
                swap(nums, index + 1, i);
                index++;
            }
        }

        swap(nums, index, start);
        return index;
    }

    private static void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}
