package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(new CombinationSum_39().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        doCombination(candidates, target, res, path, 0);
        return res;
    }

    private void doCombination(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        //遇到这一类相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索 每一次搜索的时候设置 下一轮搜索的起点 start 不然就会出现[2,2,3][2,3,2][3,2,2]的答案
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            doCombination(candidates, target - candidates[i], res, path, i);
            path.remove(path.size() - 1);
        }
    }
}
