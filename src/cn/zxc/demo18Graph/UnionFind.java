package cn.zxc.demo18Graph;

public  class UnionFind {
    // 连通分量个数
     public int count;

    // 存储一棵树
     public  int[] parent;

    // 记录树的“重量”
     int[] weight;

    public UnionFind(int N) {
        this.count = N;
        this.parent = new int[N];
        this.weight = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    //将u连接到v
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootV == rootU) {
            return;
        }
        // 小树接到大树下面，较平衡
        // 小树接到大树下面，较平衡
        if (weight[rootV] > weight[rootU]) {
            parent[rootU] = rootV;
            weight[rootV] += weight[rootU];
        } else {
            parent[rootV] = rootU;
            weight[rootU] += weight[rootV];
        }
        count--;
    }

    //寻找父节点
    int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //父节点是否相同 相同就是连接
    boolean connect(int u, int v) {
        int rootV = find(v);
        int rootU = find(u);
        return rootU == rootV;
    }
}
