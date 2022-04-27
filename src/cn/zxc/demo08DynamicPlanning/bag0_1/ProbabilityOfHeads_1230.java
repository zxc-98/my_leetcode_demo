package cn.zxc.demo08DynamicPlanning.bag0_1;

public class ProbabilityOfHeads_1230 {

    public static void main(String[] args) {
        double[] prob = new double[]{0.5,0.5,0.5,0.5,0.5};
        int target = 0;

        ProbabilityOfHeads_1230 probabilityOfHeads = new ProbabilityOfHeads_1230();
        System.out.println(probabilityOfHeads.probabilityOfHeads(prob, target));
    }

    public double probabilityOfHeads(double[] prob, int target) {
        int m = prob.length;

        double[][] dp = new double[m + 1][target + 1];
        dp[0][0] = 1;

        for(int i = 1; i <=  m; i++) {
            dp[i][0] = dp[i-1][0] * (1 - prob[i-1]);
        }


        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j] * (1 - prob[j - 1]) + dp[i-1][j-1]*prob[j - 1];
            }
        }

        return dp[m][target];
    }
}
