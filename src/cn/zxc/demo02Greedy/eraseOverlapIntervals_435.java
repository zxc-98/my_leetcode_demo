package cn.zxc.demo02Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 重叠区间问题
 */
public class eraseOverlapIntervals_435 {
    public static void main(String[] args) {
        //int[][] nums = {{1,2},{2,3},{3,4},{1,3}};
        int[][] nums = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(nums));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);


        int curNum = intervals[0][1];
        int res = 1;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < curNum) {
            }else {
                res++;
                curNum = intervals[i][1];
            }
        }

        return res;
    }



   /* private static void qSort(int[][] intervals , int start ,int end){
        if(start<end){
            int index = getIndex(intervals,start,end);
            qSort(intervals,start,index-1);
            qSort(intervals,index+1,end);
        }
    }

    private static int getIndex(int[][] intervals ,int start ,int end){
        int temp = end ;
        swap(intervals,temp,start);

        int pivot = intervals[start][1];
        int index = start ;

        for (int i=start+1 ; i<= end ; i++){
            if(intervals[i][1]<=pivot){
                swap(intervals,i,index+1);
                index++;
            }
        }
        swap(intervals,index,start);
        return index;
    }

    private static void swap(int[][] nums , int i ,int j){
        int[] k = nums[i];
        nums[i] = nums[j];
        nums[j] = k ;
    }*/
}
