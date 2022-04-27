package cn.zxc.Interview.PerfectWorld;

import java.util.ArrayList;

public class wmsj {

    public static void main(String[] args) {
        System.out.println(method("1","-2"));
    }

    public static String method(String a , String b) {

        ArrayList<Integer> list = new ArrayList<>();
        if(a == "0" || b == "0"){
            return "0";
        }
        int flagA = 1;
        if(a.charAt(0) == '-') {
            a = a.substring(1);
            flagA = -1;
        }
        int flagB = 1;
        if(b.charAt(0) == '-') {
            b = b.substring(1);
            flagB = -1;
        }
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        int[] re=new int[c1.length+c2.length];//re保存计算结果，使用数组防止超出int类型范围
        StringBuilder sb = new StringBuilder();
        for (int i = c1.length-1; i >= 0; i--) {//从个位开始取值计算
            for (int j = c2.length-1; j >=0; j--) {//从个位开始取值计算
                int m=c1[i]-'0';//转化为整数
                int n=c2[j]-'0';//转化为整数
                int r = m * n;//计算结果
                r += re[i + j + 1];//先加上进位的值
                re[i + j + 1] = r % 10;//个位
                re[i + j] += r / 10;//进位
            }

        }

        for (int i = 0; i < re.length; i++) {
            if (re[i]==0&&sb.length()==0){//取出前置位的0
                continue;
            }
            sb.append(re[i]);
        }
        //return sb.length()==0?"0":sb.toString();//判断是否为0
        return flagA*flagB == 1 ? sb.toString() : '-'+sb.toString();
    }
}
