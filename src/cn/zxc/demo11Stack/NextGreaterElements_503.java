package cn.zxc.demo11Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElements_503 {

    public static void main(String[] args) {
        NextGreaterElements_503 nextGreaterElements = new NextGreaterElements_503();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements_2(nums)));
    }

    private int[] nextGreaterElements_2(int[] nums) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, -1);//将队列插入-1

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!queue.isEmpty() && nums[queue.peek()] < num) {
                ret[queue.pop()] = num;
            }
            if (i < nums.length) {//第二遍就不用加入队列
                queue.addFirst(i);
            }
        }
        return ret;
    }

    //自己解答版本
    public int[] nextGreaterElements_1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int[] ret = new int[nums.length];
        Deque<Integer> queue = new ArrayDeque<>();

        int i = 0;
        int count = 0;
        do {
            i = i % nums.length;
            if (i == 0) {
                count++;
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peek()]) {
                ret[queue.pop()] = nums[i];
            }

            queue.addFirst(i);
            if (!queue.isEmpty() && nums[queue.peek()] == max) {
                ret[queue.pop()] = -1;
            }
            i++;

        } while (!queue.isEmpty() || count <= 1);
        return ret;
    }
}
