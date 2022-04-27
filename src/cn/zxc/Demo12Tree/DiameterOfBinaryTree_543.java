package cn.zxc.Demo12Tree;

public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {
        DiameterOfBinaryTree_543 m = new DiameterOfBinaryTree_543();

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);


        root.left = left1;

        System.out.println(m.maxPath);

    }


    private int maxPath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int l = diameterOfBinaryTree(root.left);
        int r = diameterOfBinaryTree(root.right);
        maxPath = Math.max(maxPath, l + r);
        return 1 + Math.max(l, r);
    }
}
