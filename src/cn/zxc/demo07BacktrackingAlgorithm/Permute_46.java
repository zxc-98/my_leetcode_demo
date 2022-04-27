package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute_46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permute_46().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();

        boolean[] hasVisited = new boolean[nums.length];
        //Arrays.fill(hasVisited,false);

        doPermute(nums, temp, res, hasVisited);
        return res;
    }

    private void doPermute(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] hasVisited) {
        if (temp.size() == nums.length) {
            //在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。
            // 这些地址被添加到 res 变量，但实际上指向的是同一块内存地址，因此我们会看到6个空的列表对象。解决的方法很简单，在 res.add(path); 这里做一次拷贝即可
            res.add(new ArrayList<>(temp));//为什么需要从新创建一个新的arrayList呢？
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (hasVisited[i]) {
                continue;
            }
            temp.add(nums[i]);
            hasVisited[i] = true;
            doPermute(nums, temp, res, hasVisited);
            hasVisited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
