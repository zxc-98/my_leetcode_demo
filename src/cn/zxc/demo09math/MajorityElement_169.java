package cn.zxc.demo09math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_169 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement_vote(nums));
    }

    private static int majorityElement_vote(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {//相同 投票+1
                count++;
            } else if (count-- == 0) { //票数为0时换人且票数置1
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }


    public static int majorityElement_bucket(int[] nums) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int num : nums) {
            occurences.put(num, occurences.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int key : occurences.keySet()) {
            int frequence = occurences.get(key);
            if (bucket[frequence] == null) {
                bucket[frequence] = new ArrayList<>();
            }
            bucket[frequence].add(key);
        }

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                return bucket[i].get(0);
            }
        }
        return 0;
    }
}
