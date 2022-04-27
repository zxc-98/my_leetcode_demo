package cn.zxc.Interview.huawei;

import java.util.*;

public class Main1_413 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        List<machine> machineList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String[] strings = sc.next().split(",");
            machine m = new machine(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),Integer.parseInt(strings[3]),Integer.parseInt(strings[4]));
            machineList.add(m);
        }

        List<Integer> requireList = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            requireList.add(sc.nextInt());
        }
        int number = requireList.get(0);
        int strategy = requireList.get(1);
        int cpuCount = requireList.get(2);
        int memSize = requireList.get(3);
        int cpuArch = requireList.get(4);
        int supportNP = requireList.get(5);

        List<machine> okMachine = new ArrayList<>();

        for (machine m : machineList) {
            if(m.cpuNum >= cpuCount && m.memory >= memSize && (cpuArch==9 || m.cpuA == cpuArch) && (supportNP == 2 ||m.npS == supportNP)) {
                okMachine.add(m);
            }
        }

        if (okMachine.size() <= number) {
            System.out.print(okMachine.size() + " ");
            for (int i = 0; i < okMachine.size(); i++) {
                if (i == okMachine.size() - 1) {
                    System.out.print(okMachine.get(i).id + "");
                }
                else {
                    System.out.print(okMachine.get(i).id + " ");
                }
            }
        }
        else {
            PriorityQueue<machine> pq;
            if (strategy == 1) {
                 pq = new PriorityQueue<>((o1, o2) -> {
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
                 });

            }
            else {
                pq = new PriorityQueue<>((o1, o2) -> {
                    if (o1.memory > o2.memory) {
                        return 1;
                    }
                    else if (o1.memory < o2.memory) {
                        return -1;
                    }
                    else {
                        if (o1.cpuNum > o2.cpuNum) {
                            return 1;
                        }
                        else if (o1.cpuNum < o2.cpuNum) {
                            return -1;
                        }
                        else {
                            return o1.id - o2.id;
                        }
                    }
                });
            }
            pq.addAll(okMachine);
            int index = number;
            System.out.print(number + " ");
            while (index-- > 0) {
                machine p = pq.poll();
                if (index == 0) {
                    System.out.print(p.id);
                }
                else {
                    System.out.print(p.id + " ");
                }
            }
        }
    }

    static class machine {
        int id;
        int cpuNum;
        int memory;
        int cpuA;
        int npS;

        public machine(int id, int cpuNum, int memory, int cpuA, int npS) {
            this.id = id;
            this.cpuNum = cpuNum;
            this.memory = memory;
            this.cpuA = cpuA;
            this.npS = npS;
        }
    }
}
