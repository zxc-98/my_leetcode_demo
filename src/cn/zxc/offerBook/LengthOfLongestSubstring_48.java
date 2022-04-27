package cn.zxc.offerBook;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_48 {
    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring_48 lengthOfLongestSubstring = new LengthOfLongestSubstring_48();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int tmp = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);

            map.put(s.charAt(i), i);
            if (tmp < i - index) {
                tmp = tmp + 1;
            } else {
                tmp = i - index;
            }

            res = Math.max(res, tmp);
        }
        return res;

    }
}
