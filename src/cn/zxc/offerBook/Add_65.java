package cn.zxc.offerBook;

public class Add_65 {

    public static void main(String[] args) {
        int a = 111;
        int b = 899;
        System.out.println(new Add_65().add(a, b));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }

        return a;
    }
}
