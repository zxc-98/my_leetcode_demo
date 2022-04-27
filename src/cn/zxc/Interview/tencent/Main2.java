package cn.zxc.Interview.tencent;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        if( n == 1) {
            System.out.println(1);
        }

        long[] A = new long[n + 1];
        long[] B = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                A[i] += (A[i - 1] + i);
            }
            else {
                A[i] = A[i -1];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                B[i] += (B[i + 1] + i + 1);
            }
            else {
                B[i] = B[i + 1];
            }
        }

        Long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, Math.abs(A[i] - B[i]));
        }

        System.out.println(ans);
    }
}
