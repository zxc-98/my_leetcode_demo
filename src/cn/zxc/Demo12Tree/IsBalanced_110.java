package cn.zxc.Demo12Tree;

public class IsBalanced_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(new IsBalanced_110().isBalanced(null));

    }

    private boolean ret = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return ret;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            ret = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
