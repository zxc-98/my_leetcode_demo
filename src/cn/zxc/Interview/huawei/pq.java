package cn.zxc.Interview.huawei;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {

    public static void main(String[] args) {
        PriorityQueue<machine> pq = new PriorityQueue<>(new Comparator<machine>() {
            @Override
            public int compare(machine o1, machine o2) {
                if (o1.cpuNum > o2.cpuNum) {
                    return 1;
                }
                else if (o1.cpuNum < o2.cpuNum) {
                    return -1;
                }
                else {
                    if (o1.memory > o2.memory) {
                        return 1;
                    }
                    else if (o1.memory < o2.memory) {
                        return -1;
                    }
                    else {
                        return o1.id - o2.id;
                    }
                }
            }
        });
        machine m1 = new machine(0,100,50);
        machine m2 = new machine(1,100,50);

        pq.add(m1);
        pq.add(m2);

        System.out.println(pq.poll().id);


    }

    static class machine {
        int id;
        int cpuNum;
        int memory;

        public machine(int id, int cpuNum, int memory) {
            this.id = id;
            this.cpuNum = cpuNum;
            this.memory = memory;
        }
    }
}
