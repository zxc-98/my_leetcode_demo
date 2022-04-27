package cn.zxc.demo10ListNode;

public class ReverseKGroup_25 {
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

        System.out.println(reverseKGroup(head, 3));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode limit = dummy;
        ListNode pre = dummy;

        while(true) {
            int i = k - 1;
            int j = k;

            while(limit != null && j-- > 0) {
                limit = limit.next;
            }

            if(limit == null) {
                break;
            }
            ListNode last = pre.next;

            while(i-- > 0) {
                ListNode next = last.next;
                last.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

            pre = last;
            limit = last;
        }

        return dummy.next;
    }
}
