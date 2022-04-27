package cn.zxc.Demo12Tree.preInPos;


import cn.zxc.Demo12Tree.TreeNode;

import java.util.*;

public class posOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);

        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(posOrder(root));
    }

    public static List<Integer>  posOrder(TreeNode head) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stackTmp = new ArrayDeque<>();
        stackTmp.addLast(head);


        while (!stackTmp.isEmpty()) {
            TreeNode curNode = stackTmp.removeFirst();
            res.add(curNode.val);
            if (curNode.left != null) {
                stackTmp.add(curNode.left);
            }
            if (curNode.right != null) {
                stackTmp.add(curNode.right);
            }
        }
        return res;
    }
}
