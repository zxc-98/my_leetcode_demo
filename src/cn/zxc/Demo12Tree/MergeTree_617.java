package cn.zxc.Demo12Tree;

public class MergeTree_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode ret = new TreeNode(root1.val + root2.val);
        ret.left = mergeTrees(root1.left, root2.left);
        ret.right = mergeTrees(root1.right, root2.right);

        return ret;
    }
}
