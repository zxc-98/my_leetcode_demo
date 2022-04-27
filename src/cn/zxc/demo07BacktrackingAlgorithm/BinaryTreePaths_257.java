package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    public static void main(String[] args) {

    }

    //自己想的 用时较短
/*
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root==null){
            return res;
        }

        StringBuilder str = new StringBuilder();
        str.append(root.val);

        getTreePaths(root,res,str);

        return res ;
    }

    private void getTreePaths(TreeNode root, List<String> res, StringBuilder str) {
        if (root.left==null && root.right==null){
            res.add(str.toString());
            return ;
        }

        if (root.left!=null){
            str.append("->");
            str.append(root.left.val);
            int nLen = String.valueOf(root.left.val).length();
            getTreePaths(root.left,res,str);
            root.left=null;
            str.delete(str.length()-nLen-2,str.length());
        }

        if (root.right!=null){
            str.append("->");
            str.append(root.right.val);
            int nLen = String.valueOf(root.right.val).length();
            getTreePaths(root.right,res,str);
            root.right=null;
            str.delete(str.length()-nLen-2,str.length());
        }
    }
    */

    //题解中简洁的题解 : 用时较长 题解简单

    private final List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        findPath(root, "");

        return res;
    }

    private void findPath(TreeNode root, String curPath) {
        if (root == null) {
            return;
        }

        findPath(root.left, curPath + root.val + "->");
        findPath(root.right, curPath + root.val + "->");
        if (root.left == null && root.right == null) {
            res.add(curPath + root.val);
        }
    }


}
