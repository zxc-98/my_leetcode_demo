package cn.zxc.offerBook;
import java.util.*;

public class ReConstructBinaryTree_7 {

    public static void main(String[] args) {
        ReConstructBinaryTree_7 reConstructBinaryTree = new ReConstructBinaryTree_7();
        System.out.println(reConstructBinaryTree.method(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
    }

    private Map<Integer,Integer> dic = new HashMap<>();
    private int[] pre ;
    public  TreeNode method(int[] pre, int[] order) {
        this.pre = pre;
        for(int i = 0; i < order.length; i++) {
            dic.put(order[i],i);//记录中序遍历的位置
        }
        return reConstruct(0, pre.length - 1, 0);
    }

    private TreeNode reConstruct(int preL, int preR, int i) {//中序遍历左节点位置
        if(preL > preR) {
            return null;
        }

        int val = pre[preL];
        TreeNode node  = new TreeNode(val);

        int indexOfOrder = dic.get(val);
        int leftSize = indexOfOrder - i;

        node.left = reConstruct(preL+1,preL+leftSize,i);
        node.right = reConstruct(preL+leftSize+1,preR,i+leftSize+1);
        return node;
    }
}
