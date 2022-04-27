package cn.zxc.demo10ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {

    public static void main(String[] args) {
        ReorderList_143 reorderList = new ReorderList_143();
        ListNode head1 = new ListNode(1);
        ListNode headNext1 = new ListNode(2);
        ListNode headNext2 = new ListNode(3);
        ListNode headNext3 = new ListNode(4);
        head1.next = headNext1;
        headNext1.next = headNext2;
        headNext2.next = headNext3;

        reorderList.reorderList_2(head1);
        System.out.println(head1);
    }

    public void reorderList_1(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        ListNode l1 = head;
        while(l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while(left < right) {
            list.get(left).next = list.get(right);
            left++;
            if(left == right) {
                break;
            }
            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;
    }

    public void reorderList_2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode midHead = slow;
        while(midHead != null) {
            ListNode next = midHead.next;
            midHead.next = pre;
            pre = midHead;
            midHead = next;
        }

        ListNode l1 ;
        ListNode l2 ;
        while(head != null && pre != null) {
            l1 = head.next;
            l2 = pre.next;

            head.next = pre;
            head = l1;

            pre.next = head;
            pre = l2;
        }
    }

}
