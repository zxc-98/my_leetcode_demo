package cn.zxc.demo09math;

public class ConvertToTitle_168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(2));
    }


    private static String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }

        columnNumber--;//需要移位 不然就得到下一位
        return convertToTitle(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }
}
