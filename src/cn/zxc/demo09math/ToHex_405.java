package cn.zxc.demo09math;

//16进制转换
public class ToHex_405 {
    public static void main(String[] args) {
        System.out.println(new ToHex_405().toHex(26));
    }

    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(map[num & 0b111]);//26=00011010 取出1010-->a 再取出0001-->1
            num >>>= 4;//无符号位移处理
        }

        return sb.reverse().toString();
    }
}
