package cn.zxc.offerBook;

import java.util.ArrayDeque;
import java.util.Deque;


public class MaxQueue_59 {

    public static void main(String[] args) {
        MaxQueue_59 maxQueue = new MaxQueue_59();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);

        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }


    private Deque<Integer> queue, help;

    public MaxQueue_59() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return help.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        while (!help.isEmpty() && help.peekLast() < value) {
            help.removeLast();
        }
        help.addLast(value);
        queue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        if (!help.isEmpty() && help.peek().equals(queue.peek())) {
            help.removeFirst();
        }

        return queue.pop();
    }
}
