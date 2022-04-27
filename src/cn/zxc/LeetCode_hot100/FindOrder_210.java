package cn.zxc.LeetCode_hot100;

import java.util.*;

public class FindOrder_210 {

    public static void main(String[] args) {
        int[][] prerequisites = {{5,3},{5,4},{3,0},{3,1},{4,1},{4,2}};
        int numCourses = 6 ;

        System.out.println(Arrays.toString(new FindOrder_210().findOrder(numCourses, prerequisites)));
    }

    private Deque<Integer> postOrder = new ArrayDeque<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new List[numCourses] ;//图：集合数组

        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();//集合数组初始化
        }

        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }

        boolean[] globalMarked = new boolean[numCourses];
        boolean[] localMarked = new boolean[numCourses];


        for (int i = 0; i < numCourses; i++) {
            if(hasCycle(globalMarked,localMarked,graphic,i)){
                return new int[]{};
            }
        }

        int[] ret = new int[postOrder.size()];
        int index = 0 ;
        while (!postOrder.isEmpty()){
            ret[index++] = postOrder.removeFirst();
        }

        return ret;
    }

    private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic, int cur) {
        if (localMarked[cur]) return true;//当前路径被第二次访问，说明有环
        if (globalMarked[cur]) return false;//被全局路径检验过，路径没问题

        globalMarked[cur] = true ;
        localMarked[cur] = true ;

        for (int nextNode : graphic[cur]){
            if (hasCycle(globalMarked,localMarked,graphic,nextNode)){
                return true ; // 满足条件 说明有环
            }
        }
        localMarked[cur] = false;
        postOrder.addLast(cur);//遍历顺序就是课表安排的顺序
        return false ;
    }
}
