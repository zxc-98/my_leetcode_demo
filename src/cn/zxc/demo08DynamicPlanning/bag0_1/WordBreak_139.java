package cn.zxc.demo08DynamicPlanning.bag0_1;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("dog");
        wordDict.add("s");
        wordDict.add("gs");
        System.out.println(new WordBreak_139().wordBreak("dogs", wordDict));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int lenWord = word.length();
                if (lenWord <= i && word.equals(s.substring(i - lenWord, i))) {
                    dp[i] =  dp[i - lenWord];
                }
            }
        }
        return dp[s.length()];
    }
}
