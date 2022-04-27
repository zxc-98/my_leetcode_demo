package cn.zxc.demo01Sort;

import java.util.Arrays;

import static cn.zxc.demo01Sort.HeapSort.swap;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {11, 1, 2, 9, 7, 5, 6, 4};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        quickSort(arr, left, right);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    // 基准点在左边
    //先右再左
    //内层循环条件不能少
    // 平均时间复杂度为nlog2n 最坏的时间复杂度为n2(元素一样)
    private static int getIndex(int[] arr, int left, int right) {
        int temp = arr[left];
        int start = left;

        while (left < right) {
            while (left < right && temp < arr[right]) {
                right--;
            }

            //内层循环条件不能少 left < right example: 51236789
            while (left < right && temp >= arr[left]) {
                left++;
            }
            swap(arr, left, right);

        }
        swap(arr, left, start);
        return left;
    }




    //单边排序
    private static void quickSort_1(int[] arr, int l, int r) {
        if(l >= r) {
            return;
        }
        int index = partition(arr, l, r);

        quickSort_1(arr, l, index - 1);
        quickSort_1(arr, index + 1, r);
    }

    private static int partition(int[] a, int l, int r) {
        int pv = a[r];
        int i = l;
        int j = l;

        for(; j < r; j++) {
            if(a[j] < pv) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i , r);
        return i;
    }
}
