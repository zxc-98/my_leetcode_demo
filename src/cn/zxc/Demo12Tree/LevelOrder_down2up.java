package cn.zxc.Demo12Tree;

import java.util.*;

public class LevelOrder_down2up {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        System.out.println(new LevelOrder_down2up().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 结果集
        List<List<Integer>> tmp = new ArrayList<>();
        // 待遍历的层级节点列表
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();
            // 创建保存当前层序的结果集列表
            List<Integer> item = new ArrayList<>();
            // 遍历当前层序，加入结果集及获取下一层级的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = list.remove();
                item.add(node.val);
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
            tmp.add(item);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i));
        }

        return res;
    }
}
