package cn.zxc.offerBook;

public class MergeTwoLists_25 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(2);
        ListNode list12 = new ListNode(4);
        list1.next = list11;
        list11.next = list12;


        ListNode list2 = new ListNode(1);
        ListNode list21 = new ListNode(3);
        ListNode list22 = new ListNode(4);
        list2.next = list21;
        list21.next = list22;

        System.out.println(new MergeTwoLists_25().mergeTwoLists(list1, list2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode pre = ret;//

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ret.next = l2;
                break;
            }

            if (l2 == null) {
                ret.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                ret.next = l2;
                ret = ret.next;
                l2 = l2.next;
            } else {
                ret.next = l1;
                ret = ret.next;//
                l1 = l1.next;
            }
        }

        return pre.next;
    }
}
