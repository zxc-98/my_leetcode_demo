package cn.zxc.demo16SlidingWindow;

import java.util.Arrays;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring_3();
        String s = " ";
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        Arrays.fill(last, -1);// 记录上次提交过的位置

        int left = 0;
        int right = 0;
        int res = 0;

        while(right < s.length()) {
            int index = s.charAt(right);
            left = Math.max(last[index] + 1, left); //记录上次提交过的最大位置

            res = Math.max(res, right - left +1);
            last[index] = right;
            right++;
        }

        return res;
    }
}
