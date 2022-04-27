package cn.zxc.offerBook;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWords_58 {

    public static void main(String[] args) {
        ReverseWords_58 reverseWords = new ReverseWords_58();
        System.out.println(reverseWords.reverseWords(" the sky is blue "));
    }

    public String reverseWords(String s) {
        //String trim() 返回字符串的副本，忽略前导空白和尾部空白。
        //String[] split(String regex) 根据给定正则表达式的匹配拆分此字符串。
        String[] strs = s.trim().split(" ");//以空格的形式分割字符串
        StringBuilder ret = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) continue;
            ret.append(strs[i]).append(" ");
        }
        return ret.toString().trim();//再次忽略前后的空白
    }
}
