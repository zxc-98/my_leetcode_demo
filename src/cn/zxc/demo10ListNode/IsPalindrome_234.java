package cn.zxc.demo10ListNode;

public class IsPalindrome_234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headNext1 = new ListNode(2);
        ListNode headNext2 = new ListNode(2);
        head.next = headNext1;
        headNext1.next = headNext2;


        System.out.println(new IsPalindrome_234().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode half = half(slow);


        while (head != null && half != null) {
            if (half.val != head.val) {
                return false;
            }
            half = half.next;
            head = head.next;
        }
        return true;
    }


    private ListNode half(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) { //链表如何反转
            ListNode nextNode = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = nextNode;
        }
        return newHead.next;
    }
}
