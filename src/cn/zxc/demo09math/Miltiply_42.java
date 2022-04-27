package cn.zxc.demo09math;

import java.awt.*;

public class Miltiply_42 {

    public static void main(String[] args) {
        Miltiply_42 multiply = new Miltiply_42();
        System.out.println(multiply.multiply("12", "34"));
    }


    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--) {
            int c2 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int c1 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + c1 * c2;
                res[i + j + 1] = sum % 10;//余数 直接放入
                res[i + j] += sum / 10;//进位 ++
            }
        }


        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (int r : res) {
            if (flag == 0 && r == 0) {
                continue;
            }
            flag = 1;
            sb.append(r);
        }
        return sb.toString();
    }
}
