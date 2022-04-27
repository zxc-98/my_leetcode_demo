package cn.zxc.demo02Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabel(S));
    }

    private static List<Integer> partitionLabel(String s) {
        int start = 0, end = 0;
        int length = s.length();

        //存储s中的字符出现的最后位置
        int[] last = new int[26];
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;//数组的索引是26字母出现的顺序 数组的值是字符最后出现的值 s.charAt(i)-'a'
        }

        //数组的索引是26字母出现的顺序 数组的值是字符最后出现的值
        //
        //遍历整个数组 查找该字符最后出现的位置 和end比较大小
        //
        //一个区间的结束条件是i==end 说明在这个区间内的字符最大索引都小于end 存储结果 更新start
        List<Integer> partition = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i) {
                partition.add(end - start + 1);
                start = i + 1;//该区间结束 ，下一个区间
            }
        }
        return partition;
    }
}
