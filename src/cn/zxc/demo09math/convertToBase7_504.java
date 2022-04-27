package cn.zxc.demo09math;

public class convertToBase7_504 {
    public static void main(String[] args) {
        int num = -8;
        System.out.println(convertToBase7(num));
        System.out.println(Integer.toString(num, 7));//7进制的字符串
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        String res = "";
        int numAbs = Math.abs(num);
        while (numAbs != 0) {
            int mod = numAbs % 7;
            numAbs /= 7;

            res = mod + res;
        }
        return num > 0 ? res : "-" + res;
    }
}
