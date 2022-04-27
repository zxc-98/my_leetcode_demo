package cn.zxc.Demo12Tree;

public class HasPathSum_112 {
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

        System.out.println(hasPathSum(root, 30));
    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        if (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val)) {
            return true;
        } else {
            return false;
        }
    }
}
