package cn.zxc.demo10ListNode;

public class CopyRandomList_35 {
    public Node copyRandomList(Node head) {

        Node tmp1 = head;

        while(tmp1 != null) {
            Node next = tmp1.next;
            Node newNode = new Node(tmp1.val);
            tmp1.next = newNode;
            newNode.next = next;

            tmp1 = newNode.next;
        }

        Node pre = head;

        while(pre != null) {
            Node cur = pre.next;
            if(pre.random != null) {
                cur.random = pre.random.next;
            }
            pre = pre.next.next;
        }

        pre = head;
        Node cur = head.next;

        Node res = head.next;

        while (cur.next != null) {
            Node preNext = cur.next;
            Node curNext = preNext.next;

            pre.next = preNext;
            cur.next = curNext;

            pre = pre.next;
            cur = cur.next;
        }

        pre.next = null;
        return res;
    }
}
