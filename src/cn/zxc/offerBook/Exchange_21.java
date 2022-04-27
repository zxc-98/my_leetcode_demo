package cn.zxc.offerBook;

import java.util.Arrays;

public class Exchange_21 {

    public static void main(String[] args) {
        Exchange_21 exchange = new Exchange_21();
        int[] nums = {11, 9, 3, 7, 16, 4, 2, 0};
        System.out.println(Arrays.toString(exchange.exchange(nums)));
    }

    public int[] exchange(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            if (nums[l] % 2 == 1) {
                l++;
            }
            if (nums[h] % 2 == 0) {
                h--;
            }

            if (l < h && nums[l] % 2 == 0 && nums[h] % 2 == 1) {
                int tmp = nums[l];
                nums[l] = nums[h];
                nums[h] = tmp;
                l++;
                h--;
            }
        }
        return nums;
    }

}
