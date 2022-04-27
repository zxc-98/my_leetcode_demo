package cn.zxc.Demo12Tree;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
