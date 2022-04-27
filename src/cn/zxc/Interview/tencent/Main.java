package cn.zxc.Interview.tencent;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getNumber(new int[]{3,1,1,4,5,6}));
    }

    public int getNumber (int[] a) {
        // write code here
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }

        Set<Integer> cache = new HashSet<>();

        while (A.size() > 1) {
            List<Integer> B = new ArrayList<>();
            for (int i = 1; i <= A.size(); i++) {
                if (cache.contains(i) || isPrime(i)){
                    B.add(A.get(i - 1));
                    cache.add(i);
                }
            }
            A = B;
        }

        return A.get(0);

    }

    private boolean isPrime(int i) {
        if (i == 1) {
            return false;
        }
        int j;
        for (j = 2; j <= i; j++) {
            if (i % j == 0) {
                break;
            }
        }
        return i == j;
    }
}
