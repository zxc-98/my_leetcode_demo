package cn.zxc.demo01Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import static cn.zxc.demo01Sort.HeapSort.swap;

public class kthElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(method_heap(nums, k));
    }

    public static int method_Arrays(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public static int method_heap(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int num : nums) {
            queue.add(num);
        }

        int res = 0;
        while(k-- > 0) {
            res = queue.poll();
        }

        return res;
    }


    public static int method_quickSort(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int j = partition(nums, l, r);
            if(j == k) {
                break;
            } else if(j < k) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }

        return nums[k];
    }

    private static int partition(int[] nums, int l, int r) {
        int i = l  , j = r + 1;

        while (true) {
            while (nums[++i] < nums[l] && i < r);

            while(nums[--j] > nums[l] && j > l);

            if(i >= j) break;

            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
