package cn.zxc.Demo12Tree;


public class GetMinimumDifference_530 {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        toList(root);
        return min;
    }

    private void toList(TreeNode root) {
        if (root == null) {
            return;
        }

        toList(root.left);
        if (pre != null) {
            int d = root.val - pre.val;
            if (d < min) {
                min = d;
            }
        }
        pre = root;
        toList(root.right);
    }
}
