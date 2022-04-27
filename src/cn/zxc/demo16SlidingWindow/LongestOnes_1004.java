package cn.zxc.demo16SlidingWindow;

public class LongestOnes_1004 {

    public static void main(String[] args) {
        LongestOnes_1004 longestOnes = new LongestOnes_1004();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(longestOnes.longestOnes(nums, k));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int zeros = 0;

        while(right < nums.length) {
            if(nums[right] == 0) {
                zeros++;
            }

            while(zeros > k) {
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

}
