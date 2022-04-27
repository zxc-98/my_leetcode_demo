package cn.zxc.Demo14String;

import java.util.HashMap;
import java.util.*;

public class isAnagram_242 {


    public boolean solution1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }

        for(char ch : set) {
            if(!map1.get(ch).equals(map2.get(ch))) {
                return false;
            }
        }

        return true;
    }

    public boolean solution2(String s, String t) {
        int[] res = new int[26];

        for (char ch : s.toCharArray()) {
            res[ch - '0'] += 1;
        }

        for (char ch : t.toCharArray()) {
            res[ch - '0'] -= 1;
        }

        for (int num : res) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
