package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_216 {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new CombinationSum3_216().combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        doCombination(k, n, res, path, 1);
        return res;
    }

    private void doCombination(int k, int n, List<List<Integer>> res, List<Integer> path, int start) {
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = start; i <= 9; i++) {
            if (n < i) {
                break;
            }
            path.add(i);
            doCombination(k, n - i, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
