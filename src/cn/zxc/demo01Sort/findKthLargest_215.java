package cn.zxc.demo01Sort;

import java.util.Arrays;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素
 */
public class findKthLargest_215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int i = findKthLargest(nums, k);
        System.out.println(i);
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0 ;
        int right = nums.length -1 ;

        int target = len - k ;

        while (true){
            int index = getIndex(nums,left,right);
            if (target == index){
                return nums[index];
            }else if(target>index){
                left = index+1;
            }else {
                right = index-1;
            }
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
        return left;
    }


}
