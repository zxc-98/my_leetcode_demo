package cn.zxc.Interview.ByteDance3;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();

        int[] diff = new int[n + 2];
        for(int i = 0; i < q; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt() + 1;

            diff[left] += 1;
            diff[right] -= 1;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 1; i < n + 1; i++) {
            diff[i] += diff[i-1];
            char c = s.charAt(i-1);
            if ((diff[i] & 1) == 1) {
                if (Character.isLowerCase(c)) {
                    res.append(Character.toUpperCase(c));
                }else {
                    res.append(Character.toLowerCase(c));
                }
            }else {
                res.append(c);
            }
        }

        System.out.println(res.toString());
    }
}
