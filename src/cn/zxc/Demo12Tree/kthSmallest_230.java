package cn.zxc.Demo12Tree;

public class kthSmallest_230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(15);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        kthSmallest_230 kthSmallest = new kthSmallest_230();
        System.out.println(kthSmallest.kthSmallest(root, 1));
    }

    private int ret = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        bfs(root, k);
        return ret;
    }

    private void bfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        bfs(root.left, k);
        count++;
        if (k == count) {
            ret = root.val;
            return;
        }
        bfs(root.right, k);
    }
}
