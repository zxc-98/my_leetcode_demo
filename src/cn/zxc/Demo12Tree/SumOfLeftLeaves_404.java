package cn.zxc.Demo12Tree;

public class SumOfLeftLeaves_404 {
    public static void main(String[] args) {

        SumOfLeftLeaves_404 sum = new SumOfLeftLeaves_404();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(sum.sumOfLeftLeaves(root));

    }

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) { //遍历叶子节点 且 非空
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left); //遍历所有节点
        sumOfLeftLeaves(root.right);

        return sum;
    }
}
