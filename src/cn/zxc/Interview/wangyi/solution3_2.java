package cn.zxc.Interview.wangyi;

import java.util.*;

public class solution3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] jump = new int[N];

        for (int i = 0; i < N; i++) {
            jump[i] = sc.nextInt();
        }


        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0;
        queue.add(0);
        int step = 0;
        boolean flag = true;
        Set<Integer> set = new HashSet<>();

        while (flag && !queue.isEmpty()) {
            step += 1;
            int size = queue.size();
            while (size-- > 0) {
                Integer q = queue.removeFirst();
                if (jump[q] + q >= N) {
                    flag = false;
                    break;
                }

                if (!set.contains(q)) {
                    queue.addLast(jump[q] + q);
                    set.add(q);
                }
                if (q > left) {
                    while (left < q - 1) {
                        left++;
                        if (!set.contains(left)) {
                            queue.addLast(left);
                            set.add(left);
                        }
                    }
                    left = q;
                }
            }
        }
        System.out.println(step);

    }
}
