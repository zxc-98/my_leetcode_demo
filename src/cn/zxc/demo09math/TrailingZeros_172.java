package cn.zxc.demo09math;

public class TrailingZeros_172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    //转换成计算5出现的个数
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
