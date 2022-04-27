package cn.zxc.Demo12Tree;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 非递归中序遍历
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        List<Integer> list = InOder(root) ;
        System.out.println(list);
    }

    private static List<Integer> InOder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> res = new ArrayList<>();
        while(!stack .isEmpty()) {
            TreeNode pop = stack.pop();
            if(pop != null) {
                stack.push(pop);
                stack.push(pop.left);
            }
            else if (!stack.isEmpty()) {
                TreeNode pop1 = stack.pop();
                res.add(pop1.val);
                stack.push(pop1.right);
            }
        }

        return res;
    }

}
