package cn.zxc.Demo04DivideConquer;

import java.util.LinkedList;
import java.util.List;

/**
 * 关于树节点如何建立:TreeNode类
 */
public class GenerateTrees_95 {
    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for (TreeNode r : res) {
            System.out.println(r);
        }
    }

    private static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();//有序的序列集合
        if (n < 1) {
            return res;
        }
        res = generateSubtree(1, n);
        return res;
    }

    private static List<TreeNode> generateSubtree(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {//空节点返回
            res.add(null);
            return res;
        }

        for (int i = s; i <= e; i++) {//从开始到结束
            List<TreeNode> leftSubtree = generateSubtree(s, i - 1);
            List<TreeNode> rightSubtree = generateSubtree(i + 1, e);

            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(i);//构造方法赋值
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}


