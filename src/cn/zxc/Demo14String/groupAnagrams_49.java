package cn.zxc.Demo14String;

import java.util.*;

public class groupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);

            if(!map.containsKey(newStr)) map.put(newStr, new ArrayList<>());
            map.get(newStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
