package cn.zxc.Interview.bianlifeng;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Y = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                int num = nums[i-1];
                if(j >= num){
                    dp[i][j] = dp[i-1][j] || dp[i][j - num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int ret = 0;
        for (int i = Y; i <= sum; i++) {
            if (dp[n][i]) {
                ret = i;
                break;
            }
        }

        System.out.println(ret);
    }

}
