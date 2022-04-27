package cn.zxc.demo08DynamicPlanning;

public class NumDecoding_91 {
    public static void main(String[] args) {
        System.out.println(new NumDecoding_91().numDecodings("123"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //如果是一个字符串：'0'=0 '1'~'9'=1

        for (int i = 2; i <= n; i++) { //如果是两位数+
            int one = Integer.parseInt(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] = dp[i - 1];//历史的数据
            }
            if (one == 0) {
                continue;
            }

            int two = Integer.parseInt(s.substring(i - 2, i));//两位数满足条件 +1
            if (two <= 26) {
                dp[i] = dp[i] + 1;
            }
        }

        return dp[n];
    }
}
