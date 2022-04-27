package cn.zxc.demo01Sort;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent2_347 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 1, 4, 0, 4, -1, -2, -1};

        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        //频数分布的hashMap表
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        //桶本质是一个集合类型数组 频数变成索引
        List<Integer>[] buckets = new ArrayList[nums.length];

        for (Integer key : occurrences.keySet()) {
            Integer frequents = occurrences.get(key);
            if (buckets[frequents] == null) {
                //桶的子集是一个集合 集合里面的数据类型是数字
                buckets[frequents] = new ArrayList<>();
            }
            buckets[frequents].add(key);
        }

        // 存放前k个数的集合
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && k > topK.size(); i--) {//k>topK.size()说明桶没有装满
            if (buckets[i] == null) {
                continue;
            }
            //桶没装满
            if (buckets[i].size() < (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                //大桶中装小桶的一部分  也说明结果不唯一
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < topK.size(); i++) {
            ret[i] = topK.get(i);
        }

        return ret;
    }
}
