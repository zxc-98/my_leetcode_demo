package cn.zxc.demo11Stack;

import java.util.LinkedList;
import java.util.Queue;

public class LongestValidParentheses_32 {


    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(new LongestValidParentheses_32().longestValidParentheses(s));
    }


    public int longestValidParentheses(String s) {
        int maxAns = 0;
        LinkedList<Integer> stack = new LinkedList<>();//栈的表示
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;

    }
}
