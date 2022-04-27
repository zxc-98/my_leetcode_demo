package cn.zxc.demo05BFS;

import java.util.*;

public class LeetCode_1102 {

    public static void main(String[] args) {
        LeetCode_1102 l = new LeetCode_1102();
        int[][] nums = {{3,4,6,3,4}, {0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        System.out.println(l.method(nums));
    }

    public int method(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int[][] directions = {{-1,0}, {0, -1}, {1,0}, {0,1}};


        boolean[][] hasVis = new boolean[n][m];

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        hasVis[0][0] = true;

        List<Integer> values = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node curNode = queue.removeFirst();
            values.add(nums[curNode.x][curNode.y]);

            if (curNode.x == n - 1 && curNode.y == m - 1) {
                break;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> nums[o2.x][o2.y] - nums[o1.x][o1.y]);

            for (int[] direction : directions) {
                int i = curNode.x + direction[0];
                int j = curNode.y + direction[1];
                if (i < 0 || i >= n || j < 0 || j >= m || hasVis[i][j]) {
                    continue;
                }
                pq.add(new Node(i, j));
            }

            Node p = pq.poll();
            queue.add(p);
            hasVis[p.x][p.y] = true;
        }

        int min = Integer.MAX_VALUE;
        for (Integer value : values) {
            min = Math.min(min, value);
        }

        return min;
    }

    static class Node {
        int x ;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
