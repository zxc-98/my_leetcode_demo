package cn.zxc.demo09math;

public class IsPerfectSquare_367 {

    public static void main(String[] args) {
        int num = 100;
        System.out.println(isPerfectSquare2(num));
    }


    private static boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        } else {
            for (int i = 1; i <= num / 2; i++) {
                if (i * i == num) {
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean isPerfectSquare2(int num) {//完全平方数的间隔是等差数列
        int interval = 1;
        while (num > 0) {
            num -= interval;
            interval += 2;
        }
        return num == 0;
    }
}
