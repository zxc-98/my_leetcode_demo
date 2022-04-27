package cn.zxc.Interview.meituan2;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int flag = 0;

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            int curNum = nums[i-1];
            if(curNum == -1) {
                dp[i] = dp[i-1]  + flag;
                flag = i -flag;
            }else if(curNum == 1 && (i == 1 || nums[i-2] == -1)){
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = dp[i -1 ] + 2;
            }
        }

        System.out.println(dp[n]);
    }
}
