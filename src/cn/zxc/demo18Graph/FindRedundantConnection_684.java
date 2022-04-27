package cn.zxc.demo18Graph;

public class FindRedundantConnection_684 {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,3},{1,0},{1,2},{2,3},{2,1},{3,0},{3,2}};

        System.out.println(new FindRedundantConnection_684().findRedundantConnection(edges));
    }

    public boolean findRedundantConnection(int[][] edges) {
        int N = edges.length ;
        UF uf = new UF(N);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if (uf.connect(u,v)){
                //return edge;
                return false ;
            }

            uf.union(u,v);
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


