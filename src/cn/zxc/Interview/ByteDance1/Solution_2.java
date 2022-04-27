package cn.zxc.Interview.ByteDance1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ret = method(n,k);
        System.out.println(Arrays.toString(ret));
    }


    public static int[] method(int n, int k){
        int[] ans = new int[n];

        int index = 0;
        while (k-->0){
            ans[index] = index + 1;
            index++;
        }

        boolean flag = false ;
        int odd;
        int even;
        if (index%2 == 0){
            flag = true ;
            odd = index+1;
            even = index+2;
        }else {
            even = index+1;
            odd = index+2;
        }


        if (flag){
            while (even <= n){
                ans[index++] = even;
                even += 2;
            }

            while (odd <= n){
                ans[index++] = odd;
                odd += 2;
            }

        }else {
            while (odd <= n){
                ans[index++] = odd;
                odd += 2;
            }

            while (even <= n){
                ans[index++] = even;
                even += 2;
            }
        }


        return ans;
    }
}
