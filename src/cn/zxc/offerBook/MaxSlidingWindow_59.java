package cn.zxc.offerBook;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow_59 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(new MaxSlidingWindow_59().maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];

        int right = k - 1;

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() >= k) {// 顶部超出滑动窗口的大小 移除
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);//单调栈维护的是索引位置

            if (!queue.isEmpty() && i >= right) {
                ret[i - right] = nums[queue.peek()];
            }
        }

        return ret;
    }
}
