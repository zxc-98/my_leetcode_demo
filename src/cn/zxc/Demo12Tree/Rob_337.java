package cn.zxc.Demo12Tree;

import java.util.HashMap;
import java.util.Map;

//爷爷加孙子和父亲谁偷的钱多
public class Rob_337 {
    //爷爷在计算自己能偷多少钱的时候，同时计算了 4 个孙子能偷多少钱，也计算了 2 个儿子能偷多少钱。这样在儿子当爷爷时，就会产生重复计算一遍孙子节点
    private Map<TreeNode, Integer> cache = new HashMap<>(); //为什么加cache就能减少时间？

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) return cache.get(root);
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }

        int val2 = rob(root.left) + rob(root.right);

        int ret = Math.max(val1, val2);
        cache.put(root, ret);
        return ret;
    }
}
