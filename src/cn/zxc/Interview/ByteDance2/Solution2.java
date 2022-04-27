package cn.zxc.Interview.ByteDance2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] targets = new int[n];
        for(int i = 0; i < n; i++) {
            targets[i] = sc.nextInt();
        }
        int curNum = 0;
        int curStep = 0;
        for (int i = 0; i < n; i++) {
            int step = bfs(targets[i], curNum);
            curStep += step;
            curNum = targets[i];
            System.out.println(curStep);
        }
    }

    private static int bfs(int target, int curNum) {
        if (target == curNum){
            return 0;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(curNum);
        int step = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size-- > 0) {
                int count = queue.removeFirst();
                if(count-step == target || count+step == target) {
                    return step;
                }else {
                    queue.add(count - step);
                    queue.add(count + step);
                }
            }
        }

        return 0;
    }
}
