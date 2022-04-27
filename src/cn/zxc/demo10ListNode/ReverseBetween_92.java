package cn.zxc.demo10ListNode;

public class ReverseBetween_92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(5);
        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;

        System.out.println(new ReverseBetween_92().reverseBetween(head, 1, 2));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = head;
        ListNode last = head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int i = left;
        while(i - 1 > 0) {
            if(left - 2 > 0) {
                pre = pre.next;
            }
            last = last.next;
            i--;
        }

        int j = right - left;
        while(j > 0) {
            ListNode nextNode = last.next;
            last.next = last.next.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
            j--;
        }

        return dummy.next;
    }
}
