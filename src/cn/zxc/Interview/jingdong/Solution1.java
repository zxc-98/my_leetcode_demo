package cn.zxc.Interview.jingdong;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().split(" ");
        int N = Integer.parseInt(first[0]);
        Long X = Long.parseLong(first[1]);

        char[] chars = sc.nextLine().toCharArray();
        int n = chars.length;
        List<Character> list = new ArrayList<>();
        String s = Long.toBinaryString(X);//节点位置的二进制表示

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            int curChar = chars[i];
            if (curChar == 'L') {
                list.add('0');
            }
            else if (curChar == 'R') {
                list.add('1');
            }
            else {
                list.remove(list.size() - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }

        BigInteger res = new BigInteger(sb.toString(), 2);
        System.out.println(res.toString(10));
    }
}
