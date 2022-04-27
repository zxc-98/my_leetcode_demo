package cn.zxc.Interview.ByteDance1;
import java.util.*;

public class Solution_3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ai = new int[n];
        for(int i = 0; i < n ;i++) {
            ai[i] = sc.nextInt();
        }

        String str = sc.next();

        System.out.println(minValue(k,str,ai));
    }

    public static int minValue(int k, String str, int[] ai) {
        int n = ai.length;
        int min = 0;

        int left = 0;
        int right = 0;

        while (right < n && k-- >= 0) {
            if (str.charAt(right) == 'W') {
                min += ai[right];
            }
            right++;
        }
        int ans = min;

        while (right < n){
            if(str.charAt(left) == 'W') {
                min -= ai[left];
            }
            if (str.charAt(right) == 'W') {
                min += ai[right];
            }
            left++;
            right++;
            ans = Math.min(ans,min);
        }

        return ans;
    }
}
