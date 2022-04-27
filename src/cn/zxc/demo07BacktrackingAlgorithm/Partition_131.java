package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Partition_131 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Partition_131().partition(s));
    }


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> subStrings = new ArrayList<>();

        searchPartitions(s, res, subStrings);
        return res;
    }

    private void searchPartitions(String s, List<List<String>> res, List<String> subStrings) {
        if (s.equals("")) {
            res.add(new ArrayList<>(subStrings));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String curString = s.substring(0, i);
            if (!isPalindromeString(curString)) {
                continue;
            }
            subStrings.add(curString);
            searchPartitions(s.substring(i), res, subStrings);
            subStrings.remove(subStrings.size() - 1);
        }
    }


    //判断是否是回文串
    private Boolean isPalindromeString(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
