package cn.zxc.Demo14String;

import static cn.zxc.demo01Sort.HeapSort.swap;

public class FindDuplicate_287 {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new FindDuplicate_287().findDuplicate_2(nums));
    }

    public int findDuplicate(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        return -1;
    }

    // 双指针，寻找环的入口
    public int findDuplicate_2(int[] nums) {
        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
