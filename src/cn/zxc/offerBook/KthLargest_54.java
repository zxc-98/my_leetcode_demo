package cn.zxc.offerBook;

public class KthLargest_54 {

    private int count = 0, ret = 0;

    public int kthLargest(TreeNode root, int k) {
        findKthLargest(root, k);
        return ret;
    }

    private void findKthLargest(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        findKthLargest(root.right, k);
        if (++count == k) {
            ret = root.val;
            return;
        }
        findKthLargest(root.right, k);
    }
}
