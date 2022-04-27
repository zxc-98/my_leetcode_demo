package cn.zxc.demoTest;

import java.util.*;


public class equals_test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            String s = sc.nextLine();
            int numA = 0;
            int numB = 0;
            int numC = 0;

            for(int j = 0; j < n; j++) {
                int cur = s.charAt(i);
                if (cur == 'A') {
                    numA++;
                }
                else if (cur == 'B') {
                    numB++;
                }
                else if (cur == 'C') {
                    numC++;
                }
            }


        }
    }

}

