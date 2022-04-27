package cn.zxc.Interview.meituan;
import java.util.*;
public class Solution_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //首先不反转 最大子序列和：
        int[] dp = new int[n];
        dp[0] = nums[0];
        int left = nums[0];
        int maxLeft = nums[0];

        for(int i = 1; i < n; i++) {
            left = Math.max(left + nums[i], nums[i]);
            maxLeft = Math.max(maxLeft, left);
            dp[i] = maxLeft;
        }

        int right = nums[n-1];
        int res = Math.max(0, nums[n-1]) + dp[n-2];

        for(int i = n-2; i > 0; i--) {
            right = Math.max(nums[i], nums[i] + right);
            res = Math.max(res, right + dp[i-1]);
        }

        System.out.println(res);

//        int left = nums[0];
//        int maxLeft = nums[0];
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            left = Math.max(left + nums[i], nums[i]);
//            maxLeft = Math.max(maxLeft, left);
//            dp[i] = maxLeft;
//        }
//
//        int res = dp[n - 2] + Math.max(nums[n - 1], 0);
//        int right = nums[n - 1];
//
//        for (int i = n - 2; i > 0; i--) {
//            right = Math.max(right + nums[i], nums[i]);
//            res = Math.max(res, dp[i - 1] + right);
//        }
//        System.out.println(res);
    }
}
