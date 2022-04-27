package cn.zxc.Demo12Tree;

public class TrimBST_669 {

    public static void main(String[] args) {
        TrimBST_669 trimBST = new TrimBST_669();

        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(trimBST.trimBST(root, 14, 21));
    }


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);


        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
