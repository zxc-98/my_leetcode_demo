package cn.zxc.demo10ListNode;

import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers_445 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
        ListNode headNext1 = new ListNode(2);
        ListNode headNext2 = new ListNode(4);
        ListNode headNext3 = new ListNode(3);
        head1.next = headNext1;
        headNext1.next = headNext2;
        headNext2.next = headNext3;

        ListNode head2 = new ListNode(5);
        ListNode headNext12 = new ListNode(6);
        ListNode headNext22 = new ListNode(4);
        head2.next = headNext12;
        headNext12.next = headNext22;

        System.out.println(addTwoNumbers(head1, head2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> list1 = creatList(l1);
        LinkedList<Integer> list2 = creatList(l2);

        ListNode res = new ListNode(-1);
        int carry = 0;
        while (!list1.isEmpty() || !list2.isEmpty() || carry == 1) {
            if (!list1.isEmpty()) {
                carry += list1.removeFirst();
            }

            if (!list2.isEmpty()) {
                carry += list2.removeFirst();
            }

            ListNode node = new ListNode(carry % 10);
            node.next = res.next;
            res.next = node;
            carry = carry / 10;
        }
        return res.next;
    }

    private static LinkedList<Integer> creatList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode l = head;
        while (l != null) {
            list.addFirst(l.val);
            l = l.next;
        }
        return list;
    }
}
