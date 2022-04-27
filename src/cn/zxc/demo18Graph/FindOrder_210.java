package cn.zxc.demo18Graph;

import java.util.*;

public class FindOrder_210 {

    public static void main(String[] args) {
        int n = 4;
        int[][] p = {{1,0}, {2,0}, {3,1}, {3,2}};

        System.out.println(Arrays.toString(new FindOrder_210().findOrder(n, p)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] points = new int[numCourses];//记录入度数
        List<Integer>[] graphic = new ArrayList[numCourses]; //图

        for (int[] p : prerequisites) {
            points[p[0]]++;

            if (graphic[p[1]] == null) {
                graphic[p[1]] = new ArrayList<>();
            }

            graphic[p[1]].add(p[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (points[i] == 0) {
                queue.addLast(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer p = queue.removeFirst();

                res[index++] = p;

                List<Integer> list = graphic[p];
                if (list == null) {
                    continue;
                }

                for(int l : list) {
                    points[l]--;
                    if (points[l] == 0) {
                        queue.addLast(l);
                    }
                }
            }
        }

        return index == numCourses ? res : new int[]{};
    }
}
