package cn.zxc.Demo12Tree;

import java.util.HashMap;
import java.util.Map;

//677
public class MapSum {
    private class Node {
        Node[] childs = new Node[26];//26个指向子节点的Node数组
        int value;
    }

    private Node node = new Node();

    public MapSum() {
    }

    public void insert(String key, int val) {
        insert(key, val, node);
    }

    private void insert(String key, int val, Node node) {
        if (node == null) {
            return;
        }
        if (key.length() == 0) {
            node.value = val;
            return;
        }
        int index = key.charAt(0) - 'a';
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(key.substring(1), val, node.childs[index]);
    }


    public int sum(String prefix) {
        return sum(prefix, node);
    }

    private int sum(String prefix, Node node) {
        if (node == null) {
            return 0;
        }

        if (prefix.length() != 0) {
            int index = prefix.charAt(0) - 'a';
            return sum(prefix.substring(1), node.childs[index]);
        }

        int sum = node.value;
        for (Node child : node.childs) {
            sum += sum(prefix, child);
        }

        return sum;

    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");
    }
}


