package cn.zxc.Interview.ByteDance3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int m = sc.nextInt();
        UnionFind uf = new UnionFind(total);

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            uf.union(a, b);
        }
        System.out.println(uf.size);

        Map<Integer,Integer> map = new HashMap<>();
        for (int p : uf.parent) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(int value : map.values()) {
            System.out.print((value * 579) / total  + " ");
        }
    }

    static class UnionFind {
        int[] parent ;
        int size;
        int[] weight;

        public UnionFind(int len) {
            this.parent = new int[len];
            this.size = len;
            this.weight = new int[len];

            for(int i = 0; i < len; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            if(rootI == rootJ) {
                return;
            }

            // 小树接到大树下面，较平衡
            // 将parent的树节点统一化
            if(weight[rootI] > weight[rootJ]) {
                parent[rootJ] = rootI;
                weight[rootI] += weight[rootJ];
            }else {
                parent[rootI] = rootJ;
                weight[rootJ] += weight[rootI];
            }
            size--;
        }

        int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}
