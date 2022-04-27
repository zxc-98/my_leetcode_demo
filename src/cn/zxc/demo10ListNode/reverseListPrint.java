package cn.zxc.demo10ListNode;

public class reverseListPrint {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode pre = null;
        ListNode cur = root;

        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        while (pre != null) {
            System.out.print(pre.val);
            pre = pre.next;
        }
    }
}
