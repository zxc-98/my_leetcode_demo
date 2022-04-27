package cn.zxc.Interview.meituan;
import java.util.*;
public class Solution_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }


        Arrays.sort(numbers);
        int ans = 1;
        int cur = numbers[0];
        for(int i = 1; i < n; i++) {
            if(numbers[i] <= cur + 1) {
                continue;
            }
            cur = numbers[i];
            ans++;
        }

        System.out.println(ans);
    }
}
