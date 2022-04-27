package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine_77 {

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new Combine_77().combine(n, k));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        doCombine_2(n, k, res, value, 1);
        return res;
    }

    /**
     * 起始范围发生了变化 start
     */
    private void doCombine(int n, int k, List<List<Integer>> res, List<Integer> value, int start) {
        if (k == value.size()) {
            res.add(new ArrayList<>(value));
            return;
        }

        for (int i = start; i <= n; i++) { //第一阶段的取值不需要到n，所有存在冗余
            value.add(i);
            doCombine(n, k, res, value, i + 1);
            value.remove(value.size() - 1);
        }
    }

    /**
     * 应用了减枝操作
     */
    private void doCombine_2(int n, int k, List<List<Integer>> res, List<Integer> value, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(value));
            return;
        }

        for (int i = start; i <= n + 1 - k; i++) { //取值范围 n+1-k：第一阶段到3 第二阶段到4
            value.add(i);
            doCombine_2(n, k - 1, res, value, i + 1);
            value.remove(value.size() - 1);
        }
    }
}
