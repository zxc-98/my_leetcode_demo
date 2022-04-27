package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CombinationSum2_40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new CombinationSum2_40().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Boolean[] hasVisited = new Boolean[candidates.length];
        Arrays.fill(hasVisited, false);

        Arrays.sort(candidates);
        //start保证path的值是递增的
        doCombinationSum(res, path, hasVisited, candidates, target, 0);
        //doCombinationSum_2(res,path,candidates,target,0);
        return res;
    }

    private void doCombinationSum(List<List<Integer>> res, List<Integer> path, Boolean[] hasVisited, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            //和sort配合，将重复元素剔除
            if (i > 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1]) {
                continue;
            }

            if (target < candidates[i]) {
                break;
            }

            path.add(candidates[i]);
            hasVisited[i] = true;
            doCombinationSum(res, path, hasVisited, candidates, target - candidates[i], i + 1);
            hasVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }


    private void doCombinationSum_2(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            //1.排序后，当前的值和前值相等且前值已经访问过
            //2.将重复元素剔除
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            //因为已经排序，所以当前循环直接break
            if (target < candidates[i]) {
                break;
            }

            path.add(candidates[i]);
            doCombinationSum_2(res, path, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
