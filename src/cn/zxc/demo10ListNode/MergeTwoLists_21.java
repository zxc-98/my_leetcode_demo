package cn.zxc.demo10ListNode;

public class MergeTwoLists_21 {

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

        System.out.println(mergeTwoLists(list1, list2));
    }


    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
