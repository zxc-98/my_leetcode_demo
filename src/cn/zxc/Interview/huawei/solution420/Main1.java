package cn.zxc.Interview.huawei.solution420;

import java.util.Scanner;

public class Main1 {
    private static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        dfs(score, 1 , 0);
        System.out.println(ans);
    }

    private static void dfs(int score, int i, int wrong) {
        if (score == 0) {
            ans++;
            return;
        }

        if (wrong >= 3 || i > 25) {
            return;
        }

        if (i <= 10) {
            dfs(score - 2 , i + 1 , wrong);
            dfs(score, i + 1, wrong + 1);
        }
        else if (i <= 20) {
            dfs(score - 4 , i + 1 , wrong);
            dfs(score, i + 1, wrong + 1);
        }
        else if (i <= 25) {
            dfs(score - 8 , i + 1 , wrong);
            dfs(score, i + 1, wrong + 1);
        }
    }
}
