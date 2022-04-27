package cn.zxc.offerBook;

import java.util.ArrayList;
import java.util.List;

public class PathSum_34 {

    public static void main(String[] args) {
        PathSum_34 pathSum = new PathSum_34();
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findSum(root, target, ret, path);
        return ret;
    }

    private void findSum(TreeNode root, int target, List<List<Integer>> ret, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null) {
            if (target == 0) {
                ret.add(new ArrayList<>(path));
            }
        }

        findSum(root.left, target, ret, path);
        findSum(root.right, target, ret, path);
        path.remove(path.size() - 1);
    }
}
