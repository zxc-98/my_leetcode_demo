package cn.zxc.demo10ListNode;

public class ReverseList_206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headNext1 = new ListNode(2);
        ListNode headNext2 = new ListNode(3);
        ListNode headNext3 = new ListNode(4);
        ListNode headNext4 = new ListNode(5);
        head.next = headNext1;
        headNext1.next = headNext2;
        headNext2.next = headNext3;
        headNext3.next = headNext4;

        System.out.println(reverseList2(head));
    }


    // 递归
    private static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        while (head != null) {
            ListNode next = head.next;
            ListNode newHead = reverseList1(next);//

            next.next = head;
            head.next = null;
            return newHead;
        }

        return head;
    }

    //双指针解法
    private static ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        ListNode pre = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
