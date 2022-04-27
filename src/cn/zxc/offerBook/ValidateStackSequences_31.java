package cn.zxc.offerBook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidateStackSequences_31 {
    public static void main(String[] args) {
        ValidateStackSequences_31 validateStackSequences = new ValidateStackSequences_31();
        int[] push = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences.validateStackSequences(push, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int top = 0;

        for (int j : pushed) {
            stack.push(j);

            while (!stack.isEmpty() && stack.peek() == popped[top]) {//原则：弹出的元素==栈顶元素
                top++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
