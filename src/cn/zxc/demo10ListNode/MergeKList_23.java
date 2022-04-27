package cn.zxc.demo10ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKList_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for(ListNode list : lists) {
            if(list == null) {
                continue;
            }
            while(list != null) {
                pq.add(list);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curList = dummy;
        while(!pq.isEmpty()) {
            ListNode curNode = pq.poll();
            curList.next = curNode;
            curList = curList.next;
        }

        return dummy.next;
    }
}
