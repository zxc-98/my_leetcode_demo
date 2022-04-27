package cn.zxc.demo09math;

import java.util.Arrays;

public class ProductExceptSelf_238 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        int letMul = nums[0];
        int rightMul = nums[len - 1];

        for (int i = 1; i < len; i++) { //左部分乘积
            left[i] = letMul;
            letMul *= nums[i];
        }

        for (int i = len - 2; i >= 0; i--) { //右部分乘积
            right[i] = rightMul;
            rightMul *= nums[i];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    private static int[] productExceptSelf1(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, 1);
        int letMul = nums[0];


        for (int i = 1; i < len; i++) { //左部分乘积
            res[i] = letMul;
            letMul *= nums[i];
        }

        int rightMul = nums[len - 1];

        for (int i = len - 2; i >= 0; i--) { //右部分乘积
            res[i] *= rightMul;
            rightMul *= nums[i];
        }
        return res;
    }
}
