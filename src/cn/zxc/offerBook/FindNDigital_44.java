package cn.zxc.offerBook;

public class FindNDigital_44 {

    public static void main(String[] args) {
        FindNDigital_44 findNDigital = new FindNDigital_44();
        System.out.println(findNDigital.findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
//        int start = 1 ;//数字范围开始的第一个数
//        int digital = 1;//n所在数字的位数
//        int count = 9;//占多少位
//
//        while(n > count){
//            n-=count;
//            digital+=1;
//            start*=10;
//            count = 9*digital*start;
//        }
//
//        long num = start + (n-1)/digital ;//当前数所在的位置
//        return Long.toString(num).charAt((n-1)%digital)-'0';//具体数值

        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.

    }
}
