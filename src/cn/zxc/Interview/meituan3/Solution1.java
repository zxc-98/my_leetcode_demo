package cn.zxc.Interview.meituan3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SecureCacheResponse;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder str = new StringBuilder();

        int l = n / 2 - 1;
        int r = n - n / 2;
        if (t == 1) {
            if(n % 2 != 0) {
                str.append(s.charAt(n/2));
            }
            while (l >=0 && r < n) {
                str.append(s.charAt(l--)).append(s.charAt(r++));
            }
            System.out.println(str.toString());
        }else {
            char[] arr = new char[n];
            if (n % 2 != 0) {
                arr[n/2] = s.charAt(0);
            }

            boolean flag = false;
            for(int i = n % 2 != 0 ? 1 : 0; i < n; i++) {
                char curStr = s.charAt(i);
                if (flag) {
                    arr[r++] = curStr;
                    flag = false;
                }else {
                    arr[l--] = curStr;
                    flag = true;
                }
            }

            for(char ch : arr) {
                str.append(ch);
            }

            System.out.println(str.toString());
        }
    }

}
