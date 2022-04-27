package cn.zxc.demo03BinarySearch;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根
 */
public class mySqrt_69 {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(mySqrt(x));
    }

    private static int mySqrt(int x) {
        long l = 0;
        long h = x / 2 + 1;

        while (l <= h) {
            long m = l + (h - l) / 2;
            if (m * m <= x && x < (m + 1) * (m + 1)) {
                return (int) m;
            } else if (x < m * m) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return 0;
    }
}
