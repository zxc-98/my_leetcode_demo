package cn.zxc.offerBook;

import java.util.*;

public class levelOrder_32 {

    public static void main(String[] args) {
        levelOrder_32 levelOrder = new levelOrder_32();
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);

        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        System.out.println(levelOrder.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        int flag = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();

            while (size-- > 0) {
                TreeNode curNode = queue.removeFirst();
                if (flag % 2 == 0) {
                    level.addLast(curNode.val);
                } else {
                    level.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            flag++;
            res.add(level);
        }

        return res;

    }
}
