package cn.zxc.demo01Sort;


import java.util.Arrays;

public class HeapSort_2<T extends Comparable<T>> extends Sort<T> {

    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1))
                j++;
            if (!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}


class Solution {
    public static void main(String[] args) {
        HeapSort_2<Integer> heapSort = new HeapSort_2<>();
        Integer[] nums = {2, 1, 3, 8, 5};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}