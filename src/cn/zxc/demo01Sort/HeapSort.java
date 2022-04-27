package cn.zxc.demo01Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 从右至左 从下至上 调整非叶子节点的结构 构建初始堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);//头尾进行交换
            adjustHeap(arr, 0, i);//重新对堆进行调整
        }
    }

    //调整最大顶堆
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }

            if (arr[k] > temp) { // 子节点大于父节点 下沉操作 将子节点的值赋于父节点
                arr[i] = arr[k];
                i = k;
            } else {
                break;// 否则退出循环
            }
        }
        arr[i] = temp;
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
