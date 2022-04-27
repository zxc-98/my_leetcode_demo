package cn.zxc.demo09math;

//十进制字符串相加
public class AddString415 {

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";

        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (carry == 1 || i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            sum += carry;

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
