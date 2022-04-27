package cn.zxc.demo02Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 重叠区间问题：
 * 1.尾部排序 尾部一定是递增的 所以 重叠区间的第一个尾部一定是最小的
 * 2.贪心 局部最优
 * 3.判定重叠区间  最小尾部>=头部 就是重叠区间  否则 不重叠就要更新尾部
 */
public class findMinArrowShots_452 {
    public static void main(String[] args) {
        //int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(findMinArrowShots(points));
    }

    private static int findMinArrowShots(int[][] points) {
        int N = points.length - 1;

        // 按照头部排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
/*                if(o1[0]!=o2[0]){
                    return Integer.compare(o1[0],o2[0]);
                }else {
                    return Integer.compare(o1[1],o2[1]);
                }*/
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
/*
        int res = 1;
        int pre = points[0][1];
        for (int i = 1 ;i<=N ;i++){
            if(pre<points[i][0]){
                res++;
                pre = points[i][1];
            }
        }*/
/*
        for (int i = 1; i <=N; i++) {
            if(points[i-1][1]<points[i][0]){ //不相交就可以++了
                res++;
            }else {
                points[i][1] =  Math.min(points[i][1],points[i-1][1]);//更新尾部就可以了
            }
        }
        */


        // 关于重叠区间问题

        int res = 1;
        int pre = points[0][1];

        for (int i = 1; i <= N; i++) {
            if (pre >= points[i][0]) {
                continue;
            }
            res++;
            pre = points[i][1];
        }
        return res;
    }
}
