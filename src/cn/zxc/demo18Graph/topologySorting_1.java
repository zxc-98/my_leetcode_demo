package cn.zxc.demo18Graph;

import java.lang.reflect.Array;
import java.util.*;

public class topologySorting_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] points = new int[n + 1];//记录入度数
        List<Integer>[] graphic = new ArrayList[n + 1];

        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();

            points[p2]++;
            if (graphic[p1] == null) {
                graphic[p1] = new ArrayList<>();
            }
            graphic[p1].add(p2);
        }


        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (points[i] == 0) {
                queue.addLast(i);
            }
        }

        int index = 0;
        int[] res = new int[n];

        while (!queue.isEmpty()) {
            int size = queue.size();

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            while (size-- > 0) {
                Integer p = queue.removeFirst();
                pq.add(p);
                ArrayList<Integer> list = (ArrayList<Integer>) graphic[p];
                if (list == null) {
                    continue;
                }

                for (int l : list) {
                    points[l]--;
                    if (points[l] == 0) {
                        queue.addLast(l);
                    }
                }
            }

            while (!pq.isEmpty()) {
                res[index++] = pq.poll();
            }
        }


        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.print(res[i]);
            }else {
                System.out.print(res[i] + " ");
            }
        }

    }
}
