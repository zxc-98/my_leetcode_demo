package cn.zxc.demo11Stack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 栈的使用
 */
public class IsValid_20 {

    public static void main(String[] args) {
        String s = "((";
        System.out.println(new IsValid_20().isValid(s));
    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> queue = new ArrayDeque<>();

        boolean ret = true;

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');


        Map<Character, Character> concurrentHashMap = new ConcurrentHashMap<>();




        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                queue.addFirst(c);
            } else {
                if (queue.isEmpty() || c != map.get(queue.removeFirst())) {
                    ret = false;
                    break;
                }
            }
        }
        return ret;
    }
}
