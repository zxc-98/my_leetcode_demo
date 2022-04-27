package cn.zxc.demo09math;

import java.util.HashMap;
import java.util.Map;

public class subarraySum_560 {

    public static void main(String[] args) {
        subarraySum_560 subarraySum = new subarraySum_560();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum.subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int len = nums.length ;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++) {
            sum += nums[i];
            if(map.containsValue(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;

    }

}
