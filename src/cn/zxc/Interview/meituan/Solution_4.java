package cn.zxc.Interview.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_4 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int next ;
        int[][] operations = new int[m][4];

        for(int i = 0; i < m; i++) {
            String curStr = br.readLine();
            String[] s = curStr.split(" ");
            for(int j = 0; j < s.length; j++) {
                operations[i][j] = Integer.parseInt(s[j]);
            }
        }

        int[] counts = new int[n];
        boolean[] flags = new boolean[n];
        int[] adds = new int[n];
        for (int i = 0; i < m; i++) {
            if(operations[i][0] == 1) {
                int left = operations[i][1] -1;
                int right = operations[i][2] -1;
                while(left <= right) {
                    counts[left] +=1;
                    flags[left] = true;
                    left++;
                }
            }else {
                int left = operations[i][1] -1;
                int right = operations[i][2] -1;
                int addNum = operations[i][3];
                while(left <= right) {
                    adds[left] +=addNum;
                    left++;
                }
            }
        }


//        List<Integer> dic = new ArrayList<>();
//        for (int c : counts) {
//            dic.add(c);
//        }

        Arrays.sort(counts);
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += counts[i]*nums[i];
            if(flags[i]) {
                res += adds[i];
            }
        }



        System.out.println(res);
    }
}
