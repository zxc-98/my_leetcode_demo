package cn.zxc.demo01Sort;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent_347 {
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};

        int[] res = topKFrequent_heap(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 利用快速排序思想
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] topKFrequent(int[] nums, int k) {
        //hashmap构造数的频率
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);//getOrDefault有键存在就返回该键的值 ，否则返回默认值 不存在频数就是0
        }

        //构造频数的数组
        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> valuesEntry : occurrences.entrySet()) {
            Integer num = valuesEntry.getKey();
            Integer count = valuesEntry.getValue();
            int[] value = new int[]{num, count};
            values.add(value);
        }

        int[] ret = new int[k];

        qSort(values, 0, values.size() - 1, ret, 0, k); //快速排序算法

        return ret;
    }

    private static void qSort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        // 随机抽取出一个数
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        // 将开头和选中的值进行交换
        Collections.swap(values, picked, start);
        //前两步可以直接省略 但是随机抽取会更快


        int pivot = values.get(start)[1]; // 获取抽取值的频数 因为交换了 就在开头了呀
        int index = start;

        //快速排序  把大于抽样值的样本甩前面
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) { //仔细研究一下  需求少 给的无序的较多 自然是需要减少范围再便利一次的嘛
            qSort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int j = start; j <= index; j++) {
                ret[retIndex++] = values.get(j)[0];//将前数放进去就可以
            }
            if (k > index - start + 1) {
                qSort(values, index + 1, end, ret, retIndex, k - (index - start + 1));//仔细研究一下
            }

        }
    }


    // 堆排序
    private static int[] topKFrequent_heap(int[] nums, int k) {
        //频数分布的hashMap表
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // 小根堆 根据频数排序
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> occurrences.get(o1) - occurrences.get(o2));

       for(int key : occurrences.keySet()) {
           if(pq.size() < k) {
               pq.add(key);
           }else if (occurrences.get(key) > occurrences.get(pq.peek())) {
                   pq.poll();
                   pq.add(key);
               }
           }

       int[] ret = new int[k];
       int index = 0;

       while (!pq.isEmpty()) {
           ret[index++] = pq.poll();
       }

       return ret;
    }
}
