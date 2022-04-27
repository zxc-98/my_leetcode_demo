package cn.zxc.Demo12Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AverageOfLevels_637 {


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

        System.out.println(averageOfLevels(root));
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        List<Double> ret = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0, count = 0.0;
            while (size-- > 0) {
                count++;
                TreeNode cur = queue.removeFirst();
                sum += cur.val;

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }

                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            ret.add(sum / count);
        }

        return ret;
    }
}
