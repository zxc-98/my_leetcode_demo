package cn.zxc.offerBook;

import java.util.*;

public class FirstUniqChar_50 {

    public static void main(String[] args) {
        FirstUniqChar_50 firstUniqChar = new FirstUniqChar_50();
        System.out.println(firstUniqChar.firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();//初始的hash表是栈形式的  有序hash有顺序

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)));
        }
        for (Character key : map.keySet()) {
            if (!map.get(key)) {
                return key;
            }
        }

        return ' ';

    }
}
