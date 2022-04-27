package cn.zxc.demo18Graph;

import cn.zxc.LeetCode_hot100.CanFinish_207;

import java.util.*;

public class canFinish_207 {
    public static void main(String[] args) {
        CanFinish_207 canFinish = new CanFinish_207();

        int numCourses = 2;
        int[][] prerequisites = {};

        System.out.println(canFinish_bfs_2(numCourses, prerequisites));
    }

    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }

        boolean[] globalVisited = new boolean[numCourses];
        boolean[] localVisited = new boolean[numCourses];

        //判断有环还是没环
//        return !dfs(graph, globalVisited, localVisited, 0);
        //所有课程都要判断有没有环
        for(int i = 0; i < numCourses; i++) {
            if(dfs(graph, globalVisited, localVisited, i)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(ArrayList<Integer>[] graph, boolean[] globalVisited, boolean[] localVisited, int cur) {
        if(localVisited[cur]) return true;//说明有环
        if(globalVisited[cur]) return false;

        globalVisited[cur] = true;
        localVisited[cur] = true;

        for(int next : graph[cur]) {
            if(dfs(graph, globalVisited, localVisited, next)) {
                return true;
            }
        }
        localVisited[cur] = false;
        return false;
    }

    // bfs
    public static boolean canFinish_bfs(int numCourses, int[][] prerequisites) {

        Set<Integer>[] graphic = new HashSet[numCourses];
        int[] nums = new int[numCourses];//

        for(int[] pre : prerequisites) {
            if (graphic[pre[1]] == null) {
                graphic[pre[1]] = new HashSet<>();
            }
            graphic[pre[1]].add(pre[0]);
            nums[pre[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(nums[i] == 0){
                queue.addLast(i);
            }
        }

        int count = 0;//可以完成的课程数量
        while(!queue.isEmpty()) {
            int curNum = queue.removeFirst();
            count++;

            if (graphic[curNum] == null) {
                continue;
            }
            for(int s : graphic[curNum]) {
                nums[s]--;
                if(nums[s] == 0) {
                    queue.add(s);
                }
            }
        }

        return count == numCourses;
    }


    public static boolean canFinish_bfs_2(int numCourses, int[][] prerequisites) {
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


        int index = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                index++;
                Integer p = queue.removeFirst();
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

        return index == numCourses ;

    }

}
