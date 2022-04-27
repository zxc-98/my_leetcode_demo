package cn.zxc.Interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split("");

        int[] nums = new int[m];
        for(int i = 0; i < m;i++) {
            nums[i] = sc.nextInt();
        }

        int x = n, y = n, z = n;
        for(int i = 0; i < m; i++) {
            String curString = strs[i];
            if(curString.equals("x")) {
                x = Math.max(nums[i], x - nums[i]);
            }else if (curString.equals("y")) {
                y = Math.max(nums[i], y - nums[i]);
            }else {
                z = Math.max(nums[i], z - nums[i]);
            }
            System.out.println(x*y*z);
        }
    }
}
