package cn.zxc.Interview.huawei.solution420;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int _val){
        this.val = _val;
        this.left = null;
        this.right = null;
    }
}
public class Main_test_other {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        temp = temp.substring(1,temp.length()-1);
        String[] str = temp.split(",");
        int[] nums1 = new int[str.length];
        for(int i =0;i<str.length;i++) nums1[i] = Integer.parseInt(str[i]);
        String[] nodePath = scanner.nextLine().split("/");
        int[] nodePathNum = new int[nodePath.length-1];
        for(int i = 1;i<nodePath.length;i++) nodePathNum[i-1] = Integer.parseInt(nodePath[i]);

        temp = scanner.nextLine();
        temp = temp.substring(1,temp.length()-1);
        str = temp.split(",");
        int[] nums2 = new int[str.length];
        for(int i =0;i<str.length;i++) nums2[i] = Integer.parseInt(str[i]);

        int k = 1;
        TreeNode root = new TreeNode(nums1[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(k<nums1.length && nums1[k]!=0) {
                node.left = new TreeNode(nums1[k]);
                queue.add(node.left);
            }
            if(k+1<nums1.length && nums1[k+1]!=0){
                node.right = new TreeNode(nums1[k+1]);
                queue.add(node.right);
            }
            k = k +2;
        }

        k = 1;
        TreeNode root2 = new TreeNode(nums2[0]);
        queue = new LinkedList<>();
        queue.add(root2);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(k<nums2.length && nums2[k]!=0) {
                node.left = new TreeNode(nums2[k]);
                queue.add(node.left);
            }
            if(k+1<nums2.length && nums2[k+1]!=0){
                node.right = new TreeNode(nums2[k+1]);
                queue.add(node.right);
            }
            k = k +2;
        }

        if(nodePathNum.length>1) {
            replace(root,root2,nodePathNum,1);
        }else root = root2;
        queue = new LinkedList<>();
        queue.add(root);
        String ans = "[";
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans = ans + node.val + "," ;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        ans = ans.substring(0,ans.length()-1) +"]";
        System.out.println(ans);

    }

    static void inorder(TreeNode node){
        if(node==null) return;
        System.out.println(node.val);
        inorder(node.left);
        inorder(node.right);
    }

    static void replace(TreeNode root,TreeNode root2,int[] path,int i){
        if(i==path.length-1){

            if(root.left!=null && root.left.val == path[i]){
                root.left = root2;
                return;
            }else if(root.right!=null && root.right.val == path[i]){

                root.right = root2;
                return;
            }
        }

        if(root.left!=null && root.left.val == path[i]){
            replace(root.left,root2,path,i+1);
        }else if(root.right!=null && root.right.val == path[i]){
            replace(root.right,root2,path,i+1);
        }
    }
}
