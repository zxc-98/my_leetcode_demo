package cn.zxc.Interview.ByteDance1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , m = sc.nextInt() ,q = sc.nextInt();

        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str1 = sc.next();
            for(int j = 0; j < m; j++){
                matrix[i][j] = str1.charAt(j);
            }
        }

        String str = sc.next();
        int[] ret = method(matrix, str, n, m, q);
        System.out.print(ret[0]);
        System.out.print(" ");
        System.out.print(ret[1]);
    }

    public static int[] method(char[][] matrix, String str, int n, int m, int q){
        int[] res = new int[2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < q) {
            char curChar = str.charAt(k);
            k++;
            int preI = i ;
            int preJ = j ;
            if (curChar == 'W'){
                i -= 1;
            }else if(curChar == 'A'){
                j -= 1;
            }else if(curChar == 'S'){
                i += 1;
            }else {
                j += 1;
            }
            if (i < 0 || i >= m || j < 0 || j > n || matrix[i][j] == '1'){
                i = preI;
                j = preJ;
            }
        }
        res[0] = i+1;
        res[1] = j+1;
        return res;
    }

}
