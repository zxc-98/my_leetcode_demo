package cn.zxc.demo10ListNode;

public class DeleteDuplicates_83 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list13 = new ListNode(3);
        ListNode list14 = new ListNode(3);

        list1.next = list11;
        list11.next = list12;
        list12.next = list13;
        list13.next = list14;

        System.out.println(deleteDuplicates2(list1));
    }


    //直接一步解决
    private static ListNode deleteDuplicates1(ListNode head) {
        ListNode l1 = head;
        while (l1.next != null) {
            if (l1.val == l1.next.val) {
                l1.next = l1.next.next;
            } else {
                l1 = l1.next;
            }

        }
        return head;
    }


    //递归
    private static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates2(head.next);

        /*if (head.next.val == head.val){
            head.next = deleteDuplicates2(head.next.next);
        }else {
            head.next = deleteDuplicates2(head.next);
        }*/
        return head.val == head.next.val ? head.next : head;
    }

}
