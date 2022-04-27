package cn.zxc.Demo04DivideConquer;


public class mergeKLists_23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        ListNode l3 = new ListNode(2);
        ListNode l31 = new ListNode(6);
        l3.next = l31;

        ListNode[] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        System.out.println(new mergeKLists_23().mergeKLists(lists));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        return merge(lists, 0, lists.length -1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        //将list集合拆开 终止条件是返回一个集合
        if(left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    // 将两个集合合并
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) {
                return l2;
            }

            if(l2 == null) {
                return l1;
            }

            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
    }


}
