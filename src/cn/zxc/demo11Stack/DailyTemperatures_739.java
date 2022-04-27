package cn.zxc.demo11Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures_739 {


    public static void main(String[] args) {
        DailyTemperatures_739 dailyTemperatures = new DailyTemperatures_739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures_2(temperatures)));
    }


    public int[] dailyTemperatures_1(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int count = 1;
            for (int j = i + 1; j <= temperatures.length; j++) {
                if (j < temperatures.length && temperatures[i] > temperatures[j]) {
                    count++;
                } else if (j == temperatures.length) {
                    count = 0;
                } else {
                    break;
                }
            }
            ret[i] = count;
        }

        return ret;
    }

    public int[] dailyTemperatures_2(int[] temperatures) {
        Deque<Integer> queue = new ArrayDeque<>();//栈中存放的是单调的 index
        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) { //i 维护当前下标
            while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peek()]) {//维护一个单调栈
                ret[queue.peek()] = i - queue.pop();
            }
            queue.addFirst(i);//给栈 增加元素 当前值小于栈顶元素
        }
        return ret;
    }
}
