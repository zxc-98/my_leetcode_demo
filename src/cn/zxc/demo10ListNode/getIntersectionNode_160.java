package cn.zxc.demo10ListNode;

public class getIntersectionNode_160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;

        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;// a+c+b
            l2 = (l2 == null) ? headA : l2.next;// b+c+a
        }

        return l1;
    }
}
