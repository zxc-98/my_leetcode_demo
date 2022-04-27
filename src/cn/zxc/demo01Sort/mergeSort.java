package cn.zxc.demo01Sort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 8, 9, 5, 4, 3, 1, 10, 22, 15};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    private static void sort(int[] arr) { //排序
        int N = arr.length;
        int[] temp = new int[arr.length];//创建一个临时数组进行存储
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right) / 2;

        if (left < right) {
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
