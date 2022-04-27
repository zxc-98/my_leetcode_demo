package cn.zxc.Demo12Tree.preInPos;


import cn.zxc.Demo12Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class preOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(15);

        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(20);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(preOrder(root));
    }

    public static List<Integer> preOrder(TreeNode head) {
        List<Integer> list = new ArrayList<>();

        if (head != null) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(head);

            while (!queue.isEmpty()) {
                TreeNode node = queue.removeFirst();

                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return list;
    }
}
