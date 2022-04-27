package cn.zxc.Demo12Tree;

public class MinDepth_111 {

    public static void main(String[] args) {
        MinDepth_111 minD = new MinDepth_111();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(minD.minDepth(root));

    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }
}
