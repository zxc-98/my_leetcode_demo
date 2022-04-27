package cn.zxc.offerBook;

public class MyPow_16 {
    public static void main(String[] args) {
        MyPow_16 myPow = new MyPow_16();
        System.out.println(myPow.myPow(2.1, 3));
    }

    public double myPow(double x, int n) {
        if (n > 0) {
            return x * myPow(x, n - 1);
        }
        if (n < 0) {
            return (1 / x) * myPow(x, n + 1);
        }


        return 1.0;
    }
}
