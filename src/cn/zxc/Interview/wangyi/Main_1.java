package cn.zxc.Interview.wangyi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jump = new int[n];
        boolean[] canWin = new boolean[n];

        for (int i = 0; i < n; i++) {
            jump[i] = sc.nextInt();
            canWin[i] = i - jump[i] < 0 || i + jump[i] >= n;
        }


        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(jump[0]);
        int ans = 1;

        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int loc = queue.poll();
                if (canWin[loc]) {
                    System.out.println(ans + 1);
                    return;
                }

                queue.add(loc + jump[i]);
                queue.add(loc - jump[i]);
            }

            ans++;
        }
    }
}
