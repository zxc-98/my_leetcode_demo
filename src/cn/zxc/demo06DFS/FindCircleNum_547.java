package cn.zxc.demo06DFS;

/**
 *
 */
public class FindCircleNum_547 {

    public static void main(String[] args) {
        FindCircleNum_547 findCircleNum = new FindCircleNum_547();
        int[][] isConnected = {{1, 0, 1, 0, 1}, {0, 1, 1, 0, 0}, {1, 1, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 1, 1, 1}};
        System.out.println(findCircleNum.findCircleNum(isConnected));


    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int circleNum = 0;

        Boolean[] hasVisited = new Boolean[n];
        for (int i = 0; i < n; i++) {
            hasVisited[i] = false;
        }


        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) { //没有遍历过的
                dfs(isConnected, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] isConnected, int i, Boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !hasVisited[j]) {//没有遍历且没有连接
                dfs(isConnected, j, hasVisited);
            }
        }
    }
}
