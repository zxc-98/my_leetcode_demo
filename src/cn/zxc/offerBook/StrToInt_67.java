package cn.zxc.offerBook;

import java.util.ArrayDeque;
import java.util.Deque;

//实现把字符串转换成整数这个功能
public class StrToInt_67 {

    public static void main(String[] args) {
        StrToInt_67 strToInt = new StrToInt_67();
        System.out.println(strToInt.strToInt("-1010023630o4"));
    }

    public int strToInt(String str) {
        str = str.trim();

        if (str.length() == 0) {
            return 0;
        }

        int ret = 0;
        boolean negative = false;

        int max = Integer.MAX_VALUE / 10;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur >= '0' && cur <= '9') {
                if (ret > max && cur > '7') { // 主要是超出范围如何计算
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ret = ret * 10 + (cur - '0');
            } else if (i == 0 && cur == '-') {
                negative = true;
            } else if (i == 0 && cur == '+') {
            } else {
                break;
            }
        }

        return ret;
    }
}
