package cn.zxc.Demo12Tree;

public class find {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(15);

        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(20);

        root.left = left1;
        root.right = right1;

        right1.left = left2;
        right1.right = right2;

        insert(11, root);
        System.out.println(root);
    }

    public static TreeNode findX(TreeNode root, int target) {
        while ( root != null && target != root.val ) {
            if(target < root.val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }

        return root;
    }

    public static void insert(int data , TreeNode root) {
        TreeNode newNode = new TreeNode(data);
        if(root == null) {
            //如果是第一个节点，也就是根节点为null,直接创建一个新的节点即可　
        }
        else {
            TreeNode current = root;
            //current节点的父节点
            TreeNode parent;
            //循环查找插入的位置
            while(true) {
                parent = current;
                //如果插入的值小于当前节点的值，从左子树查找
                if(data < current.val) {
                    current = current.left;
                    //直到当前节点为null
                    if(current == null) {
                        //设置当前节点的父节点的左子节点为新创建的节点
                        parent.left = newNode;
                        return;
                    }

                }
                //如果插入的值大于当前节点的值，从左子树查找
                else {
                    current = current.right;
                    //直到当前节点为null
                    if(current == null) {
                        //设置当前节点的父节点的右子节点为新创建的节点
                        parent.right = newNode;
                        return;
                    }
                }
            }// end of while(true)
        }
    }

}
