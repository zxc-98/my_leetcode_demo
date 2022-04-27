package cn.zxc.offerBook;

public class NthUglyNumber_49 {
    //一个丑数 = 另一个丑数*2，3，5得到
    public int nthUglyNumber(int n) {
        int a = 0 , b = 0 , c = 0 ;//记录丑数从三个中哪里出来
        int[] dp = new int[n];

        dp[0] = 1;//第一个丑数为1

        for (int i = 1; i < n; i++) {
            int n2 = dp[a]*2, n3=dp[b]*3 ,n5=dp[c]*5; //记录每个丑数是否已经被乘2， 乘3， 乘5
            dp[i] = Math.min(Math.min(n2,n3),n5); //选择最小的丑数

            /*
                不可以这样写
                if (dp[i] == n2) a++;
                else if (dp[i] == n3) b++;
                else c++;

                这样写会获得重复的丑数
             */
            if (dp[i]==n2) a++;//选择完之后 ++
            if (dp[i]==n3) b++;
            if (dp[i]==n5) c++;
        }

        return dp[n-1];
    }
}
