package cn.zxc.demo05BFS;

import java.util.*;

public class NumBusesToDestination_815 {

    public static void main(String[] args) {
        int[][] route = {{1,2,7}, {3,6,7}};
        int source = 1;
        int target = 6;
        System.out.println(new NumBusesToDestination_815().numBusesToDestination(route, source, target));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        int m = routes[0].length;

        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[][] edges = new boolean[n][m];

        int maxNum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int route : routes[i]) {
                List<Integer> list = map.getOrDefault(route, new ArrayList<>());
                for(int j : list) {
                    edges[i][j] = edges[j][i] = true;
                }

                list.add(i);
                map.put(route, list);
                maxNum = Math.max(maxNum, route);
            }
        }

        int[] dis = new int[n];

        Arrays.fill(dis, -1);

        Deque<Integer> queue = new ArrayDeque<>();

        for (int bus : map.getOrDefault(source, new ArrayList<>())) {
            dis[bus] = 1;
            queue.add(bus);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int y = 0; y < n; y++) {
                if (edges[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.add(y);
                }
            }
        }

        int minStep = Integer.MAX_VALUE;
        for(int bus : map.getOrDefault(target, new ArrayList<>())) {
            if (dis[bus] != -1) {
                minStep = Math.min(minStep, dis[bus]);
            }
        }

        return minStep == Integer.MAX_VALUE ? -1 : minStep;

    }
}
