package cn.zxc.Interview.meituan2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];

        for(int i = 0;i < m; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(method(n, m, nums));


    }

    public static int method(int n, int m, int[] nums) {

        int index = 0;

        while (index < m && nums[index] != 1){
            index++;
        }

        if(index == m) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        int res = 1;

        for(int i = index; i < m; i++) {
            set.add(nums[i]);

            if(set.size() == n) {
                res++;
                set.clear();
                set.add(nums[i]);
            }
        }

        return res;
    }
}
