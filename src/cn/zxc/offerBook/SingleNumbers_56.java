package cn.zxc.offerBook;

import java.util.Arrays;

public class SingleNumbers_56 {

    public static void main(String[] args) {
        SingleNumbers_56 singleNumbers = new SingleNumbers_56();
        int[] nums = {1, 1, 2, 2, 3, 5};
        System.out.println(Arrays.toString(singleNumbers.singleNumbers(nums)));
    }

    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;//获得两个额外数值的异或值
        }

        int m = 1;//得到从右至左 x^y首次出现1的位置 原理：当x^y在该位置值为1时，说明在该位置的xy值不一样
        while ((m & n) == 0) {
            m <<= 1;//m进行左移
        }
        int x = 0;
        int y = 0;
        for (int num : nums) {//进行分组
            if ((m & num) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};

    }
}
