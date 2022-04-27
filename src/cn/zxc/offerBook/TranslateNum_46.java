package cn.zxc.offerBook;

public class TranslateNum_46 {

    public static void main(String[] args) {
        TranslateNum_46 translateNum = new TranslateNum_46();
        int num = 510;
        System.out.println(translateNum.translateNum(num));
    }

    public int translateNum(int num) {
        String strNum = num + "";
        int[] dp = new int[strNum.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= strNum.length(); i++) {
            if (strNum.substring(i - 2, i).compareTo("10") >= 0 && strNum.substring(i - 2, i).compareTo("26") < 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[strNum.length()];
    }
}
