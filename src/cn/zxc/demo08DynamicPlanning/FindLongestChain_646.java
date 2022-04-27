package cn.zxc.demo08DynamicPlanning;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain_646 {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new FindLongestChain_646().findLongestChain(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });


        int[] dp = new int[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    max = Math.max(1, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int ret = 0;
        for (int d : dp) {
            ret = Math.max(ret, d);
        }

        return ret;
    }
}
