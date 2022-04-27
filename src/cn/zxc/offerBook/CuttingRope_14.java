package cn.zxc.offerBook;

public class CuttingRope_14 {

    public static void main(String[] args) {
        int n = 35;
        CuttingRope_14 cuttingRope = new CuttingRope_14();
        System.out.println(cuttingRope.cuttingRope_2(n));
    }

    // 正常解法 没有求模运算 使用动态规划
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), dp[j] * (i - j)));
                //max = max % 1000000007 ;
            }
            dp[i] = max ;
        }

        return dp[n];
    }

    // 循环求余方法 求模运算
    public int cuttingRope_2(int n){
        if (n<3){
            return n-1 ;
        }
        int b = n % 3 , p = 1000000007 ;

        long a = n / 3 , mod = 1 ;

        for (int i = 0; i < (b==1 ? a-1 : a); i++) {
            mod = (3*mod) % p ;
        }

        if (b==1) return (int) ((mod*4)%p);
        if (b==2) return (int) ((mod*2)%p);
        return (int) (mod%p);
    }
}
