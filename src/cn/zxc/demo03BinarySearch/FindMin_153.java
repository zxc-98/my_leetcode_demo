package cn.zxc.demo03BinarySearch;

public class FindMin_153 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin_BS(nums));
    }

    private static int findMin_BS(int[] nums) {//二分法
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    private static int findMin_Increase(int[] nums) {//查找递增区间
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                index++;
            } else {
                break;
            }
        }
        if (index == nums.length) {
            return nums[0];
        } else {
            return nums[index];
        }
    }
}
