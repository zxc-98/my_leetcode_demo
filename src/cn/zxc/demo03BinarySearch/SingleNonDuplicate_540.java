package cn.zxc.demo03BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNonDuplicate_540 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate_BinarySearch(nums));
    }

    /**
     * 使用桶方法去查找 太慢了！！复杂度太高
     *
     * @param nums
     * @return
     */
    private static int singleNonDuplicate_bucket(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[3];

        for (Integer num : occurrences.keySet()) {
            int frequents = occurrences.get(num);
            if (buckets[frequents] == null) {
                buckets[frequents] = new ArrayList<>();
            }
            buckets[frequents].add(num);
        }

        return buckets[1].get(0);
    }

    private static int singleNonDuplicate_forLoop(int[] nums) {
        int i = 0;
        for (i = 1; i < nums.length; i += 2) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                break;
            }
        }
        return nums[i - 1];
    }

    /**
     * 应用二分法：保证m一定是偶数 l 和 h 也是偶数 因为目标值的索引一定是偶数
     * 满足nums[m]==nums[m+1]说明目标值在m的左边 不满足说明目标值在m的右边
     *
     * @param nums
     * @return
     */
    private static int singleNonDuplicate_BinarySearch(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
