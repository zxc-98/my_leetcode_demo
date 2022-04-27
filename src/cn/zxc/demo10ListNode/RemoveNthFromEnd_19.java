package cn.zxc.demo10ListNode;

public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode headNext1 = new ListNode(2);
//        ListNode headNext2 = new ListNode(3);
//        ListNode headNext3 = new ListNode(4);
//        ListNode headNext4 = new ListNode(5);
//        head.next = headNext1;
//        headNext1.next = headNext2;
//        headNext2.next = headNext3;
//        headNext3.next = headNext4;

        System.out.println(removeNthFromEnd(head, 1));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;

        for (int i = 0; i < n; i++) {
            q = q.next;
        }

        if (q == null) {
            return head.next;//head = [1], n = 1
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;
        return head;
    }
}
