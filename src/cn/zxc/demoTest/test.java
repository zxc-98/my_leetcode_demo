package cn.zxc.demoTest;

import java.util.*;

public class test {

    public static void main(String[] args) {
        test1(7, 3);
    }

    private static void test1(int n, int m) {

        Vector<Integer> v = new Vector<>();

        Collections.synchronizedList(new ArrayList<>());

        List<Integer> c = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            c.add(i);
        }

        int[] ret = new int[n + 1];
        int i = 1;
        while (i % m == 0 && !c.isEmpty()) {
            System.out.println();
            i++;
        }

    }
}
