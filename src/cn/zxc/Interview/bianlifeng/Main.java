package cn.zxc.Interview.bianlifeng;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] purchase = new int[n];
        for (int i = 0; i < n; i++) {
            purchase[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[][] combine = new int[m][n+1];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n + 1; j++) {
                combine[i][j] = sc.nextInt();
            }
        }






    }

}
