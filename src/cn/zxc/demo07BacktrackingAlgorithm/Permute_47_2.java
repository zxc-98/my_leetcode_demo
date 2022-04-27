package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute_47_2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 2};
        System.out.println(new Permute_47_2().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> value = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        Boolean[] hasVisited = new Boolean[nums.length];
        Arrays.fill(hasVisited, false);

        searchPermute(nums, value, res, hasVisited);
        return res;
    }

    private void searchPermute(int[] nums, List<Integer> value, List<List<Integer>> res, Boolean[] hasVisited) {
        if (value.size() == nums.length) { //&& !res.contains(value)
            res.add(new ArrayList<>(value));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {// !hasVisited[i - 1]来去重主要是通过限制一下两个相邻的重复数字的访问顺序
                continue;
            }

            if (hasVisited[i]) {
                continue;
            }
            int curValue = nums[i];
            value.add(curValue);
            hasVisited[i] = true;
            searchPermute(nums, value, res, hasVisited);
            hasVisited[i] = false;
            value.remove(value.size() - 1);
        }
    }
}
