package cn.zxc.offerBook;

public class CountDigitOne_43 {

    public static void main(String[] args) {
        CountDigitOne_43 countDigitOne = new CountDigitOne_43();
        System.out.println(countDigitOne.countDigitOne_1(32104));
    }

    //超出时间范围
    public int countDigitOne(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int count = 0 ;
            int cur = i ;
            while (cur!=0) {
                if (cur%10==1) count++;
                cur /= 10;
            }
            dp[i] = dp[i-1] + count;
        }

        return dp[n];
    }

    public int countDigitOne_1(int n) {
        int res = 0 , digit = 1 ;
        int low = 0 , high = n/10 , cur = n%10;

        while (cur!=0 || high!=0){
            if(cur==0){
                res += high*digit;
            }else if(cur==1){
                res += high*digit+low+1;
            }else {
                res += (high+1)*digit;
            }

            low = low + cur*digit ;
            cur = high%10;
            digit*=10;
            high/=10;
        }

        return res;

    }
}
