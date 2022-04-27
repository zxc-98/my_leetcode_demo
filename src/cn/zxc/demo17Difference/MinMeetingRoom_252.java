package cn.zxc.demo17Difference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRoom_252 {

    public static void main(String[] args) {
        MinMeetingRoom_252 meetingRoom = new MinMeetingRoom_252();
        int[][] intervals = {{0,30}, {5,10}, {15, 20}};
        System.out.println(meetingRoom.minMeetingRoom_1(intervals));
    }

    public int minMeetingRoom(int[][] intervals) {

        int times = 0;
        for(int[] interval : intervals) {
            times = Math.max(interval[1], times);
        }

        int[] meetingTimes = new int[times + 1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            meetingTimes[start] += 1;
            meetingTimes[end] -= 1;
        }

        int maxRoom = meetingTimes[0];
        for(int i = 1; i < meetingTimes.length; i++) {
            meetingTimes[i] += meetingTimes[i-1];
            maxRoom = Math.max(maxRoom, meetingTimes[i]);
        }

        return maxRoom;
    }

    public int minMeetingRoom_1(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            while (!pq.isEmpty() && pq.peek() < intervals[i][0]) {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return pq.size();
    }
}
