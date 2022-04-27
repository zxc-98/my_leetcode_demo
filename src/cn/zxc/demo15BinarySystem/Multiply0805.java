package cn.zxc.demo15BinarySystem;

public class Multiply0805 {

    public static void main(String[] args) {
        Multiply0805 multiply = new Multiply0805();

        System.out.println(multiply.multiply(3,4));
    }

    public int multiply(int A, int B) {
        return multi(Math.max(A, B), Math.min(A, B));
    }

    private int multi(int l, int s) {
        if(s == 1) return l;
        if(s == 2) return l + l;

        int c = 0;
        if((s ^ 1) > 0) {
            c = l;
        }
        return multi(l, s >> 1) + multi(l, s >> 1) + c ;
    }
}
