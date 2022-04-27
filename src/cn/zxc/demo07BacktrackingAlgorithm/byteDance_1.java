package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字节面试题 本质也是回溯全排列问题
 */
public class byteDance_1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("i");
        list.add("love");
        list.add("u");
        list.add("much");

        String str = "iloveumuch";

        System.out.println(isContains_dp(list, str));
    }

    //dp  完全背包问题
    public static Boolean isContains_dp(List<String> list, String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String str : list) {
                if (i >= str.length() && str.equals(s.substring(i - str.length(), i))) {
                    dp[i] = dp[i] || dp[i - str.length()];
                }
            }
        }
        return dp[s.length()];
    }


    //bfs
    public Boolean isContains(List<String> list, String s) {
        StringBuilder res = new StringBuilder();
        boolean[] hasVisited = new boolean[list.size()];
        return backtrack(list, res, s, hasVisited);

    }

    private Boolean backtrack(List<String> list, StringBuilder res, String s, boolean[] hasVisited) {
        if (s.equals(res.toString())) {
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            if (hasVisited[i]) {
                continue;
            }

            String curStr = list.get(i);
            res.append(curStr);
            hasVisited[i] = true;
            if (backtrack(list, res, s, hasVisited)) {
                return true;
            }
            hasVisited[i] = false;
            res.delete(res.length() - curStr.length(), res.length());
        }
        return false;
    }
}
