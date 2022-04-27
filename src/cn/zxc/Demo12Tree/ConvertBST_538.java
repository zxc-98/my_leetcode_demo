package cn.zxc.Demo12Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ConvertBST_538 {

    public static void main(String[] args) {

        ConvertBST_538 convertBST = new ConvertBST_538();
        TreeNode root = new TreeNode(9);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(15);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(convertBST.convertBST(root));
    }

    public TreeNode convertBST(TreeNode root) {
        bfs(root);
        return root;
    }

    private int sum = 0;

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // 右中左 求累加
        if (root.right != null) bfs(root.right);
        sum += root.val;
        root.val = sum;
        if (root.left != null) bfs(root.left);


    }

}
