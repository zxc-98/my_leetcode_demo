package cn.zxc.offerBook;

public class IsMatch_19 {

    public static void main(String[] args) {
        IsMatch_19 isMatch = new IsMatch_19();
        System.out.println(isMatch.isMatch("aaa","a*"));
    }
    public boolean isMatch(String s, String p) {
        int m = s.length() ;
        int n = p.length() ;
        boolean[][] dp = new boolean[m+1][n+1] ;

        dp[0][0] = true;

        //初始化
        for (int j = 2; j <= n ; j+=2) {
            dp[0][j] = p.charAt(j-1)=='*' && dp[0][j-2];//偶数位为* 前一个偶数位为真
        }

        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
//                if (p.charAt(j-1)=='*'){
                        //
//                    dp[i][j] = dp[i][j-2] || (dp[i-1][j] && s.charAt(i-1)==p.charAt(j-2)) || (dp[i-1][j] && p.charAt(j-2)=='.');
//                }else {
//                    dp[i][j] = (dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1)) || (dp[i-1][j-1] && p.charAt(j-1)=='.');
//                }

                dp[i][j] = p.charAt(j-1)=='*' ? dp[i][j-2] || (dp[i-1][j] && s.charAt(i-1)==p.charAt(j-2)) || (dp[i-1][j] && p.charAt(j-2)=='.'):
                        (dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1)) || (dp[i-1][j-1] && p.charAt(j-1)=='.');
            }
        }

        return dp[m][n];

    }
}
