package cn.zxc.offerBook;

public class LowestCommonAncestor_68 {

    public static void main(String[] args) {
        LowestCommonAncestor_68 lowestCommonAncestor = new LowestCommonAncestor_68();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        TreeNode p = new TreeNode(20);
        TreeNode q = new TreeNode(7);

        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
