package cn.zxc.Interview.A360;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 2];

        for(int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        nums[0] = Integer.MAX_VALUE;
        nums[n+1] = Integer.MAX_VALUE;

        int[] dp = new int[n+2];
        Arrays.fill(dp, 1);

        int left = 1;
        int right = n;

        while(left <= right) {
            if(nums[left] > nums[left - 1]) {
                dp[left] += dp[left -1];
            }

            if (left <= right && nums[left] > nums[left + 1]) {
                dp[left] += dp[left + 1];
            }

            left++;

            if(left <= right && nums[right] > nums[right - 1]) {
                dp[right] += dp[right -1];
            }

            if (left <= right && nums[right] > nums[right + 1]) {
                dp[right] += dp[right + 1];
            }
            right--;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
