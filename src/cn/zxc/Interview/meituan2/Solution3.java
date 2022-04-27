package cn.zxc.Interview.meituan2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] menu = new int[n][2];

        for(int i = 0; i < n; i++) {
            menu[i][0] = sc.nextInt();
            menu[i][1] = sc.nextInt();
        }

    }
}
