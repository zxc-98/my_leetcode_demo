package cn.zxc.demo18Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class calcEquation_399 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(2 * equationsSize);

        int id = 0;
        for(int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if(!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }

            if(!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }

            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        int queriesSize = queries.size();
        double[] res = new double[queriesSize];

        for(int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if(id1 == null || id2 == null) {
                res[i] = -1.0d;
            }else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }

        return res;
    }

    private class UnionFind {
        private int[] parent;

        private double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double values) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            weight[rootX] = weight[y] * values / weight[x];
        }

        // 路径压缩
        public int find(int x) {
            if(x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }

            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return weight[x]/weight[y];
            }else {
                return -1.0d;
            }
        }
    }

}
