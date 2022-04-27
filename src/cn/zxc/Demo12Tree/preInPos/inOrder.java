package cn.zxc.Demo12Tree.preInPos;


import cn.zxc.Demo12Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class inOrder {
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

        System.out.println(inOrder(root));

    }

    public static List<Integer> inOrder(TreeNode head) {
        List<Integer> list = new ArrayList<>();

        if (head != null) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            while (!queue.isEmpty() || head!=null) {
                if (head != null) {
                    queue.addLast(head);
                    head = head.left;
                } else {
                    TreeNode node = queue.removeLast();
                    list.add(node.val);
                    head = node.right;
                }
            }
        }
        return list;
    }
}
