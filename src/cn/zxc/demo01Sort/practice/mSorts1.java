package cn.zxc.demo01Sort.practice;

import java.util.Arrays;

public class mSorts1 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 8, 9, 5, 4, 3, 1, 10, 22, 15};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;

        while (i <= mid && j <= right) {
            if(nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            }else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }

        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
