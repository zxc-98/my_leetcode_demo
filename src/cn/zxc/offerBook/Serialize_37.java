package cn.zxc.offerBook;

import java.util.*;

public class Serialize_37 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Serialize_37 serialize = new Serialize_37();
        System.out.println(serialize.serialize(root));
    }

    // Encodes a tree to a single string. 将二叉树输出成字符串形式 层序遍历
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Deque<TreeNode> queue = new LinkedList<>();//要返回null的话 必须使用LinkedList
        queue.addLast(root);

        StringBuilder res = new StringBuilder();
        res.append('[');

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();
            if (curNode != null) {
                res.append(curNode.val).append(',');

                queue.addLast(curNode.left);
                queue.addLast(curNode.right);
            } else {
                res.append("null").append(',');
            }
        }

        return res.replace(res.length() - 1, res.length(), "]").toString();
    }


    // Decodes your encoded data to tree. 字符串反序列化为树
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] strs = data.split(",");

        Deque<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strs[index++]));
        queue.addLast(root);

        while (index < queue.size() && !queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();
            if (index < queue.size() && !strs[index].equals("null")) {
                curNode.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.addLast(curNode.left);
            }
            index++;
            if (index < queue.size() && !strs[index].equals("null")) {
                curNode.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.addLast(curNode.right);
            }
            index++;
        }

        return root;
    }

}
