package cn.zxc.Demo12Tree;

import java.util.HashMap;
import java.util.Map;

public class BuilderTree_07 {

    private int[] preorder;
    private Map<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return build(0, 0, inorder.length - 1);
    }

    private TreeNode build(int root, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[root]);//创建根节点
        int i = dic.get(preorder[root]);//中序遍历中根节点的位置
        node.left = build(root + 1, left, i - 1);//分治左节点
        node.right = build(root + i - left + 1, i + 1, right);//分治右节点
        return node;
    }
}
