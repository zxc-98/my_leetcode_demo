package cn.zxc.demo18Graph;

import java.util.Arrays;

public class FindRedundantDirectedConnection_685 {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        System.out.println(Arrays.toString(new FindRedundantDirectedConnection_685().findRedundantDirectedConnection(edges)));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] inDegree = new int[len + 1];

        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        for (int i = len - 1; i >= 0 ; i--) {
            if (inDegree[edges[i][1]] == 2) {
                // 如果不构成环，这条边就是要去掉的那条边
                if (!judgeCircle(edges,len,i)) {
                    return edges[i];
                }
            }
        }

        for (int i = len - 1; i >= 0 ; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!judgeCircle(edges,len,i)) {
                    return edges[i];
                }
            }
        }

        throw new IllegalArgumentException("输入不符合要求。");
    }

    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UF uf = new UF(len + 1);

        for (int i = 0; i < len; i++) {
            if (i == removeEdgeIndex) {
                continue;
            }

            if (!uf.union(edges[i][0], edges[i][1])) {
                // 合并失败，表示edges[i][0] 和 edges[i][1] 在一个连通分量里，即构成了环
                return true;
            }
        }

        return false;
    }

    static class UF {
        int size;
        int[] parent;
        int[] weight;

        public UF(int size) {
            this.size = size;
            this.parent = new int[size];
            this.weight = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false;
            }

            if (weight[rootX] > weight[rootY]) {
                parent[rootY] = rootX;
                weight[rootX] += weight[rootY];
            }
            else {
                parent[rootX] = rootY;
                weight[rootY] += weight[rootX];
            }

            return true;
        }
    }
}
