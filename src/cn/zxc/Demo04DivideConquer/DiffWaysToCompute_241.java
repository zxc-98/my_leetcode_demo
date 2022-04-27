package cn.zxc.Demo04DivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治：将运算符作为划分标准 可以将当前变大时划分成更小的表达式
 */
public class DiffWaysToCompute_241 {
    public static void main(String[] args) {
        String s = "2-1-1";
        //String s = "2";
        System.out.println(diffWaysToCompute(s));
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {//
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {//以字符作为划分的标准
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;//.end switch
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        //将字符转换成数字在分割成一个字符时用到
        if (list.size() == 0) {//判断条件要注意
            //Integer.valueOf()将数值转换成数字
            list.add(Integer.valueOf(expression));//?
        }
        return list;
    }
}
