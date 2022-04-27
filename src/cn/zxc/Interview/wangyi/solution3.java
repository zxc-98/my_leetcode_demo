package cn.zxc.Interview.wangyi;

import java.util.Scanner;

public class solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] jump = new int[N];

        for(int i = 0; i < N; i++) {
            jump[i] = sc.nextInt() + i;
        }

        int mx = 0;
        int pre = 0;
        int ans = 0;
        int i = 0;

        while (i < N) {
            if (jump[i] >= N) {
                ans++;
                break;
            }

            for (int j = pre; j < i; j ++) {
                mx = Math.max(mx, jump[j]);
            }

            if (mx > jump[jump[i]]) {
                ans += 2;
                pre = i;
                i = mx;
            }else {
                ans++;
                pre = i;
                i = jump[i];
            }
        }
        System.out.println(ans);
    }
}
