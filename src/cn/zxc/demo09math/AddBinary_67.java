package cn.zxc.demo09math;

//2进制字符串相加
public class AddBinary_67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println(addBinary(a, b));
    }


    public static String addBinary(String a, String b) {
        int i = a.length() - 1; //2
        int j = b.length() - 1; //1
        StringBuilder str = new StringBuilder();
        int carry = 0;

        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++; //1
            }

            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;//2
            }

            str.append(carry % 2);//0
            carry /= 2;//1  相当于进位

        }

        return str.reverse().toString();
    }
}
