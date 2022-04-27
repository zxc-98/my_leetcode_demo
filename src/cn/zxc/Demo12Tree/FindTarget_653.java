package cn.zxc.Demo12Tree;

import java.util.ArrayList;
import java.util.List;

public class FindTarget_653 {

    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        toList(root);
        int a = 0;
        int b = list.size() - 1;
        while (a != b) {
            if (list.get(a) + list.get(b) > k) {
                b--;
            } else if (list.get(a) + list.get(b) < k) {
                a++;
            } else {
                return true;
            }
        }
        return false;
    }

    private void toList(TreeNode root) {
        if (root == null) {
            return;
        }

        toList(root.left);
        list.add(root.val);
        toList(root.right);
    }
}
