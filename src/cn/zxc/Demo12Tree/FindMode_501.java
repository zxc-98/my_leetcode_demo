package cn.zxc.Demo12Tree;

import java.util.*;

public class FindMode_501 {

    public static void main(String[] args) {
        FindMode_501 findMode = new FindMode_501();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(Arrays.toString(findMode.findMode(root)));
    }

    private List<Integer> list = new ArrayList<>();
    private int cur = 1;
    private int max = 1;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        toList(root);
        int index = 0;
        int[] ret = new int[list.size()];

        for (int l : list) {
            ret[index++] = l;
        }
        return ret;
    }

    private void toList(TreeNode root) {
        if (root == null) {
            return;
        }

        toList(root.left);
        if (pre != null) {
            if (pre.val == root.val) {
                cur++;
            } else {
                cur = 1;
            }
        }

        if (cur > max) {
            max = cur;
            list.clear();
            list.add(cur);
        } else if (cur == max) {
            list.add(cur);
        }

        pre = root;//这是一个二叉搜索树 所以中序遍历树时，相同值的节点是连片的
        toList(root.right);
    }
}
