package cn.zxc.demo09math;

public class IsPowerOfThree_326 {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(9));
    }

    private static boolean isPowerOfThree(int n) {
        return (Math.pow(3, 19)) % n == 0;
    }

    public static boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
