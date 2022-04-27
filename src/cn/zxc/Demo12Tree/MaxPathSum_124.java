package cn.zxc.Demo12Tree;

public class MaxPathSum_124 {

    public static void main(String[] args) {
        MaxDepth_104 maxDepth = new MaxDepth_104();

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
//        TreeNode left2 = new TreeNode(15);
//        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;
//        right1.left = left2;
//        right1.right = right2;


        System.out.println(new MaxPathSum_124().maxPathSum(root));
    }

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int maxLeft = Math.max(0, dfs(root.left));
        int maxRight = Math.max(0, dfs(root.right));

        max = Math.max(max, root.val + maxLeft + maxRight);

        return root.val + Math.max(maxLeft , maxRight);
    }
}
