package cn.zxc.demo18Graph;

import java.util.Arrays;

public class IsBipartite_785 {


    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i]==-1 && !bfs(i,0,colors,graph)){
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int curNode, int curColor, int[] colors, int[][] graph) {

        if (colors[curNode] != -1){ //当前节点被着色了
            return colors[curNode] == curColor ; //判断当前节点是否等当前颜色
        }

        colors[curNode] = curColor;

        for(int nextNode : graph[curNode]){
            if (!bfs(nextNode,1-curColor,colors,graph)){
                return false;
            }
        }
        return true;
    }


    //并查集
    public boolean isBipartite_2(int[][] graph) {

        int N = graph.length ;
        UF uf = new UF(N);

        for(int i = 0; i < N; i++) {
            int[] e = graph[i];

            for(int w : e){
                if(uf.connect(i,w)){
                    return false;
                }

                uf.connect(e[0],w);
            }
        }

        return true;
    }

    private class UF {
        private int[] id ;

        // 构造方法
        UF(int N){
            id = new int[N+1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i ;
            }
        }

        // 将节点之间关联起来
        void union(int u, int v){
            int uId = find(u);
            int vId = find(v);
            if (uId == vId){
                return;
            }

            for(int i = 1 ; i < id.length; i++){
                if(id[i] == uId){
                    id[i] = vId ;
                }
            }
        }

        int find(int p){
            return id[p];
        }

        //如果关联的节点一样 就可以查出并集了
        boolean connect(int u, int v){
            return find(u)==find(v);
        }
    }


}
