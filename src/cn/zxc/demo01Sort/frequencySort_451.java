package cn.zxc.demo01Sort;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 451  桶排序
 */
public class frequencySort_451 {
    public static void main(String[] args) {
        String s = "aaacbb";
        String string = frequencySort(s);
        System.out.println(string);
    }

    /**
     * 桶排序步骤：
     * 1. 创建HashMap的频数分布表
     * 2. 创建桶 集合数组 频数为数组的索引 数组的值是集合类型
     *
     * @param s
     * @return
     */
    private static String frequencySort(String s) {
        //频数分布的hashMap表
        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            occurrences.put(charS, occurrences.getOrDefault(charS, 0) + 1);
        }

        //创建桶
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character key : occurrences.keySet()) {
            Integer frequents = occurrences.get(key);
            if (buckets[frequents] == null) {
                buckets[frequents] = new ArrayList<>();
            }
            buckets[frequents].add(key);
        }

        StringBuffer bf = new StringBuffer();
        for (int i = buckets.length - 1; i > 0; i--) {//桶的索引就是频数
            if (buckets[i] == null) {
                continue;
            }
            for (Character c : buckets[i]) { // 数组的子集就是一个集合
                for (int j = i; j > 0; j--) {
                    bf.append(c);
                }
            }
        }

        return bf.toString();
    }
}
