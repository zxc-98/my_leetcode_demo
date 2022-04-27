package cn.zxc.Interview.huawei.solution420;

import cn.zxc.Demo12Tree.TreeNode;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        s1 = s1.substring(1,s1.length() - 1);
        String[] char1 = s1.split(",");

        TreeNode tree1 = stringToTreeNode(char1);

        List<Integer> path = new ArrayList<>();
        String s2 = sc.nextLine();
        for (int i = 1; i < s2.length(); i += 2) {
            path.add(Integer.parseInt(String.valueOf(s2.charAt(i))));
        }

        String s3 = sc.nextLine();
        s3 = s3.substring(1,s3.length() - 1);
        String[] char2 = s3.split(",");

        TreeNode tree2 = stringToTreeNode(char2);


        if (path.size() > 1) {
            replace(tree1, tree2, path, 1);
        }else {
            tree1 = tree2;
        }

        List<Integer> ans = TreeNodeToString(tree1);

        System.out.println(ans);
    }

    private static List<Integer> TreeNodeToString(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        queue.addLast(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            list.add(p.value);

            if (p.left != null) {
                queue.add(p.left);
            }

            if (p.right != null) {
                queue.add(p.right);
            }
        }

        return list;
    }

    private static void replace(TreeNode tree1, TreeNode tree2, List<Integer> path, int i) {
        if (i == path.size() - 1) {
            if (tree1.left != null && tree1.left.value == path.get(i)) {
                tree1.left = tree2;
                return;
            }else if (tree1.right != null && tree1.right.value == path.get(i)) {
                tree1.right = tree2;
                return;
            }
        }

        if (tree1.left != null && tree1.left.value == path.get(i)) {
            replace(tree1.left, tree2,path, i + 1);
        }

        if (tree1.right != null && tree1.right.value == path.get(i)) {
            replace(tree1.right, tree2,path, i + 1);
        }
    }

    public static TreeNode stringToTreeNode(String[] strings) {
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();

            if (index < strings.length && !strings[index].equals("0")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[index]));
                p.left = left;
                queue.addLast(left);
            }
            index++;

            if (index < strings.length && !strings[index].equals("0")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[index]));
                p.right = right;
                queue.addLast(right);
            }
            index++;
        }

        return root;
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
