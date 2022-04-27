package cn.zxc.Demo12Tree;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeT<T> {
     T val;
     TreeNodeT<T> left;
     TreeNodeT<T> right;

    public TreeNodeT(T val) {
        this.val = val;
    }

    public TreeNodeT(T val, TreeNodeT<T> left, TreeNodeT<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class testTreeNode {

    public static void main(String[] args) {
        testTreeNode test = new testTreeNode();
        TreeNodeT<Integer> root = new TreeNodeT<>(1);
        root.left = new TreeNodeT<>(2);
        root.right = new TreeNodeT<>(3);

        System.out.println(test.method(root));
    }

    private List<Integer> list = new ArrayList<>();
    List<Integer> method(TreeNodeT<Integer> root) {
        if (root == null) {
            return null;
        }

        bfs(root);
        return list;
    }

    private void bfs(TreeNodeT<Integer> root) {
        if(root == null) {
            return;
        }

        list.add(root.val);
        bfs(root.left);
        bfs(root.right);
    }
}
