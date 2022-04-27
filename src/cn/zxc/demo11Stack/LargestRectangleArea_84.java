package cn.zxc.demo11Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea_84 {

    public static void main(String[] args) {
        LargestRectangleArea_84 largestRectangleArea = new LargestRectangleArea_84();
        int[] h = {2,4};
        System.out.println(largestRectangleArea.largestRectangleArea_heap_1(h));
    }

    // 暴力解法 会超时
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;

            while(left >= 0 && heights[left] >= heights[i]) {
                left--;
                count++;
            }

            while(right < heights.length && heights[right] >= heights[i]) {
                right++;
                count++;
            }

            max = Math.max(max, count * heights[i]);
        }

        return max;
    }

    // 单调栈的解法
    public int largestRectangleArea_heap(int[] heights) {
        int len = heights.length;
        if(len == 0) {
            return 0;
        }

        if(len == 1) {
            return heights[0];
        }

        int res = 0;
        int[] newHeight = new int[len + 2];
        for(int i = 1; i <= len; i++) {
            newHeight[i] = heights[i-1];
        }

        len += 2;
        heights = newHeight;
        Deque<Integer> queue = new ArrayDeque<>(len);
        queue.addLast(0);

        for(int i = 1; i < len; i++) {
            while (heights[i] < heights[queue.peekLast()]) {
                int curHeight = heights[queue.removeLast()];
                int curWidth = i - queue.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            queue.addLast(i);
        }

        return res;
    }

    public int largestRectangleArea_heap_1(int[] heights) {
        int maxValue = Integer.MIN_VALUE;
        int len = heights.length;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] nums = new int[len + 2];//添加一个0 的哨兵
        for(int i = 1; i <= heights.length; i++) {
            nums[i] = heights[i-1];
        }

        queue.addLast(0);

        for(int i = 1; i < nums.length; i++) {
            while(nums[i] < nums[queue.peekLast()]) {
                int cur = queue.removeLast();
                int left = queue.peekLast() - 1;
                int right = i;
                maxValue = Math.max(maxValue, cur * (right - left));
            }
            queue.addLast(i);
        }

        return maxValue;
    }
}
