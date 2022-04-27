package cn.zxc.Demo12Tree;

public class SortedListToBST_109 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(-10);
        ListNode list11 = new ListNode(-3);
        ListNode list12 = new ListNode(0);
        ListNode list13 = new ListNode(5);
        ListNode list14 = new ListNode(9);
        list1.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;
        list14.next = null;

        System.out.println(new SortedListToBST_109().sortedListToBST(list1));

    }

    public TreeNode sortedListToBST(ListNode head) {
        return BTS(head);
    }

    private TreeNode BTS(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {// 这步也挺重要的
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = head; // pre代表什么含义 如果初始值为null 会出现空指针异常

        while (fast != null && fast.next != null) {
            pre = slow;//这一步是为什么 如果直接用slow 答案就是[5,0,9,-3,null,null,null,-10] 出现错误
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = pre.next;
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);

        root.left = BTS(head);
        root.right = BTS(mid.next);
        return root;
    }

    private ListNode preMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = head; // pre代表什么含义

        while (fast != null && fast.next != null) {
            pre = slow;//这一步是为什么
            fast = fast.next.next;
            slow = slow.next;
        }
        return pre;
    }

}
