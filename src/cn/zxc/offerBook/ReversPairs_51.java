package cn.zxc.offerBook;

public class ReversPairs_51 {

    private int res ;
    public int reversePairs(int[] nums) {
        this.res = 0 ;
        merge(nums,0,nums.length-1) ;
        return res ;
    }

    private void merge(int[] nums, int left, int right) {
        int mid = left + (right - left)/2 ;

        if (left < right){
            merge(nums,left,mid);
            merge(nums,mid+1,right);// 分
            mergeSort(nums,left,mid,right);// 治
        }
    }

    private void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];//当前临时数组
        int index = 0 ;
        int i = left ;
        int j = mid +1 ; // i j 为两个分数组的起始位置

        while (i <= mid && j <= right){
            if (nums[i] <= nums[j]){
                temp[index++] = nums[i++];//前小于后 不满足判断条件
            }else {
                res += (mid - i + 1) ; //因为已经排序 所以5可以 后面的7也可以
                temp[index++] = nums[j++];
            }
        }

        while (i<=mid){
            temp[index++] = nums[i++];
        }

        while (j<=right){
            temp[index++] = nums[j++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[k+left] = temp[k];
        }
    }


}

class Solution {
    public static void main(String[] args) {
        ReversPairs_51 reversPairs = new ReversPairs_51();
        System.out.println(reversPairs.reversePairs(new int[]{7,5,6,4}));
    }

}
