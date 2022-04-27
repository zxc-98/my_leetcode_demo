package cn.zxc.Interview.ByteDance3;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] prices = new int[n+1][2];
        for(int i = 0; i < n; i++) {
            prices[i][0] = sc.nextInt();
            prices[i][1] = sc.nextInt();
        }

        prices[n][0] = m;
        prices[n][1] = 0;
        int ans = 0;
        int pre = 0;
        for(int i = 1; i < n + 1; i++) {
            if (prices[i][1] < prices[pre][1]) {
                int cost = (prices[i][0] - prices[pre][0])*prices[pre][1];
                ans += cost;
                pre = i;
            }
        }

        System.out.println(ans);
    }
}
