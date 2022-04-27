package cn.zxc.offerBook;

public class TreeToDoublyList_36 {
    private Node head;//定义循环链表的头节点
    private Node pre;//定义前驱节点

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        bfs(root);//遍历得到头尾节点没有相连的双向链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void bfs(Node root) {
        if (root == null) {
            return;
        }

        bfs(root.left);//中序遍历
        Node cur = root;
        if (pre != null) {
            pre.right = cur;//前驱节点的右子树为当前节点
        } else {
            head = cur;//没有前驱节点的就是头节点
        }
        cur.left = pre;//当前节点的左子树就是前驱节点
        pre = cur;//将前驱节点过渡
        bfs(root.right);
    }
}
