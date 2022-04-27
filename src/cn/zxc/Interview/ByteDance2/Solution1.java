package cn.zxc.Interview.ByteDance2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bf.readLine().toCharArray();

        int[] nums = new int[n];
        for(int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - 'a';
        }

        Arrays.sort(nums);
        int cnt = 0;
        for (int num : nums) {
            k -= num;
            if (k >= 0) {
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
