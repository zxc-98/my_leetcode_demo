package cn.zxc.demo03BinarySearch;

import static cn.zxc.demo01Sort.HeapSort.swap;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        FirstMissingPositive_41 firstMissingPositive = new FirstMissingPositive_41();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }


    public int firstMissingPositive(int[] nums) {
        int init = 1;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && nums[i] < len && nums[nums[i] - init] != nums[i]) {
                swap(nums, nums[i] - init, i);
            }
        }

        int j;
        for (j = 0; j < len; j++) {
            if (nums[j] - init != j) {
                break;
            }
        }
        return j + init;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
