package cn.zxc.Interview.meituan2;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            long cur = sc.nextLong();
            if(cur % 12 == 0 || checkOne(cur)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
    }

    private static boolean checkOne(long cur) {
        int count = 0;
        while(cur != 0) {
            if(cur % 10 == 1) {
                count++;
                if(count >= 2) {
                    return true;
                }
            }
            cur /= 10;
        }

        return false;
    }
}
