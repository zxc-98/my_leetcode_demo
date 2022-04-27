package cn.zxc.Demo12Tree;

public class IsSubtree_572 {

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        //子树都是这样做
        return isSubtreeWithRoot(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);//查根节点和左右节点
    }

    private boolean isSubtreeWithRoot(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSubtreeWithRoot(root.left, subRoot.left) || isSubtreeWithRoot(root.right, subRoot.right);
    }
}
