package cn.zxc.LeetCode_hot100;

public class DetectCycle_142 {

    public static void main(String[] args) {
        DetectCycle_142 detectCycle = new DetectCycle_142();

        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(detectCycle.detectCycle(head));
    }

    // 思路就是第一次相遇 快指针比慢指针多走n个环长度
    // 将快指针回正 快慢指针同走一步 走a步就会在入口相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null ||  head.next==null){
            return null ;
        }


        ListNode slow = head ;
        ListNode fast = head ;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
