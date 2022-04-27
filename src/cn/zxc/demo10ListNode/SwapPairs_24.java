package cn.zxc.demo10ListNode;

public class SwapPairs_24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headNext1 = new ListNode(2);
        ListNode headNext2 = new ListNode(3);
        ListNode headNext3 = new ListNode(4);
        head.next = headNext1;
        headNext1.next = headNext2;
        headNext2.next = headNext3;

        System.out.println(swapPairs1(head));
    }

    //非递归解法
    private static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy;

        while (first.next != null && first.next.next != null) {
            ListNode second = first.next;
            ListNode third = first.next.next;

            first.next = third;
            ListNode next = third.next;
            third.next = second;
            second.next = next;

            first = second;
        }

        return dummy.next;
    }

    //递归解法
    private static ListNode swapPairs2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

}
