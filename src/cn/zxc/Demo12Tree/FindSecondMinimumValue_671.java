package cn.zxc.Demo12Tree;

public class FindSecondMinimumValue_671 {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {//遍历到叶子节点 返回 -1
            return -1;
        }

        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if (root.val == leftVal) leftVal = findSecondMinimumValue(root.left);//满足条件 就向下遍历
        if (root.val == rightVal) rightVal = findSecondMinimumValue(root.right);

        if (leftVal != -1 && rightVal != -1) { //判断条件时！=-1
            return Math.min(leftVal, rightVal);
        }

        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
