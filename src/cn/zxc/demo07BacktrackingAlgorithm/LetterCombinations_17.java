package cn.zxc.demo07BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯问题:总结套路 和分治与BFS的区别
 */
public class LetterCombinations_17 {

    public static void main(String[] args) {
        LetterCombinations_17 letterCombinations = new LetterCombinations_17();
        String digit = "23";
        System.out.println(letterCombinations.letterCombination(digit));
    }

    public List<String> letterCombination(String digits) {
        List<String> combinations = new ArrayList<>();
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private final String[] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void doCombination(StringBuilder prefix, List<String> combinations, String digits) {

        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }

        int curDigit = digits.charAt(prefix.length()) - '0';//从digits中将需要的字符取出来，并转换成数字(当前按键)
        String curString = numbers[curDigit];//对应电话键的字符串

        for (char c : curString.toCharArray()) { //将字符串转成字符数组 遍历
            prefix.append(c);
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
