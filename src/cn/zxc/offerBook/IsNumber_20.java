package cn.zxc.offerBook;

public class IsNumber_20 {

    public static void main(String[] args) {
        IsNumber_20 isNumber = new IsNumber_20();
        System.out.println(isNumber.isNumber("0e"));
    }

    public boolean isNumber(String s) {
        boolean DecFlag = false;
        boolean NumFlag = false;
        boolean ENumFlag = false;
        s = s.trim();//去除首位空格

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                NumFlag = true;
            } else if ((cur == 'e' || cur == 'E') && !ENumFlag && NumFlag) {
                ENumFlag = true;
                NumFlag = false;// 后面再跟一个数字就是 将NumFlag重置
            } else if (cur == '.' && !DecFlag && !ENumFlag) {
                DecFlag = true;
            } else if ((cur == '+' || cur == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {//+ - 号只能放置在首位和e之后
            } else {
                return false;
            }
        }

        return NumFlag;
    }
}
