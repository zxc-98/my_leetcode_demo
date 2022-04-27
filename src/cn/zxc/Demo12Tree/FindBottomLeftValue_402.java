package cn.zxc.Demo12Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindBottomLeftValue_402 {

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

        System.out.println(findBottomLeftValue(root));
    }


    public static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {//从右往左 最后一个节点
            root = queue.removeFirst();
            if (root.right != null) queue.addLast(root.right);
            if (root.left != null) queue.addLast(root.left);
        }
        return root.val;
    }
}
