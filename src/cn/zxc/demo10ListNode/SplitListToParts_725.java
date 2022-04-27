package cn.zxc.demo10ListNode;

import java.util.Arrays;

public class SplitListToParts_725 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(3);

        list1.next = list11;
        list11.next = list12;

        System.out.println(Arrays.toString(splitListToParts(list1, 5)));
    }

    private static ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode l = head;
        while (l != null) {
            len++;
            l = l.next;
        }

        int a = len / k;
        int b = len % k;

        ListNode[] res = new ListNode[k];

        ListNode cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;//cur 也会跟随着变化
            int c = b-- > 0 ? 1 : 0;
            int curSize = a + c;
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return res;
    }
}
