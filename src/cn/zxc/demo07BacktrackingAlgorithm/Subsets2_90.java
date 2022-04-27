package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2_90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Subsets2_90().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        searchSubsets(nums, res, path, 0);
        return res;
    }

    private void searchSubsets(int[] nums, List<List<Integer>> res, List<Integer> path, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            searchSubsets(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
