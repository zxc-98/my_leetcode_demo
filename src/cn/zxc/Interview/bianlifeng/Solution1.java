package cn.zxc.Interview.bianlifeng;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        int N = sc.nextInt();

        int[][] products = new int[N][2];
        for(int i = 0; i < N; i++) {
            products[i][0] = sc.nextInt();
            products[i][1] = sc.nextInt();
        }

        Arrays.sort(products, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int room = products[i][0];
            int num = products[i][1];

            for(int j = 0; j < num; j++) {
                Y -= room;
                if (Y <= 0) {
                    break;
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
