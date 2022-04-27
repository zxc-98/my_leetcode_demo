package cn.zxc.Demo13Matrix;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallElement_378 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int res = kthSmallest_heap(matrix, k);
        System.out.println(res);
    }

    //二分法
    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length-1 , n = matrix[0].length-1 ;
        int min = matrix[0][0];
        int max = matrix[m][n];


        while (min <= max){
            int mid = min + (max - min)/2;
            int cnt = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] < mid) {
                        cnt++;
                    }
                }
            }

            if (cnt < k) {
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        return min ;
    }



    // 堆
    public static int kthSmallest_heap(int[][] matrix, int k) {
        int m = matrix.length-1, n = matrix[0].length-1;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();//优先队列
        for(int j = 0; j <= n; j++){
            pq.offer(new Tuple(0,j,matrix[0][j]));
        }

        for (int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if (t.x == m) continue;//t.x + 1防止越界
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;//第8个poll出来的值
    }

    static class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {//x为纵坐标的值 y为横坐标的值
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;//比较：判断小根堆还是大根堆
        }
    }
}
