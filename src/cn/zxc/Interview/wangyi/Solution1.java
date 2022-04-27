package cn.zxc.Interview.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1 {

    static int ans = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inOrder = new int[n];
        int[] posOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            posOrder[i] = sc.nextInt();
        }

        TreeNode curTree =  buildTree(inOrder, posOrder);

        depth(curTree);
        System.out.println(ans - 1);
    }

    private static int depth(TreeNode curTree) {
        if (curTree == null) {
            return 0;
        }

        int leftDepth = depth(curTree.left);
        int rightDepth = depth(curTree.right);

        ans = Math.max(ans, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static Map<Integer,Integer> dic;
    public static TreeNode buildTree(int[] inOrder, int[] posOrder) {
        int n = inOrder.length;
        dic = new HashMap<>();
        for(int i = 0; i < n; i++) {
            dic.put(inOrder[i], i);
        }

        return generate( posOrder, 0, n - 1, 0, n - 1);
    }

    private static TreeNode generate( int[] posOrder, int inLeft, int inRight, int posLeft, int posRight) {
        if (posLeft > posRight) {
            return null;
        }

        int rootPostIndex = posRight;
        int rootIndex = dic.get(posOrder[rootPostIndex]);
        int tmp = rootIndex - inLeft;
        TreeNode root = new TreeNode(posOrder[rootPostIndex]);
        root.left = generate(posOrder, inLeft, rootIndex - 1,posLeft,posLeft + tmp - 1);
        root.right = generate(posOrder, rootIndex + 1, inRight, posLeft + tmp, posRight - 1);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
