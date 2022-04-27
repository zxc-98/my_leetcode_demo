package cn.zxc.demo01Sort.practice;

import java.util.Arrays;

public class qSore1 {

    public static void main(String[] args) {
        int[] nums = {11, 1, 2, 9, 7, 5, 6, 4};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    private static int getIndex(int[] nums, int left, int right) {
        int temp = nums[left];

        while (left < right) {
            while (left < right && temp <= nums[right]) {
                right--;
            }

            nums[left] = nums[right];

            while (left < right && temp >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return right;
    }


}
