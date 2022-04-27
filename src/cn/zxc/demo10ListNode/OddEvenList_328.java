package cn.zxc.demo10ListNode;

public class OddEvenList_328 {

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

        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head;//偶数节点
        ListNode q = head.next;//奇数节点
        ListNode qhead = head.next;

        while (q != null && q.next != null) {
            p.next = p.next.next;
            p = p.next;
            q.next = q.next.next;
            q = q.next;
        }

        p.next = qhead;
        return head;
    }
}
