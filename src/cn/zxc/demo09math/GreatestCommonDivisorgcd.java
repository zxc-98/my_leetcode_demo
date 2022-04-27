package cn.zxc.demo09math;

//最大公约数和最小公倍数
public class GreatestCommonDivisorgcd {
    public static void main(String[] args) {
        System.out.println(lcm(20, 15));
    }

    //最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数=a*b/最大公约数
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
