package cn.zxc.Demo13Matrix;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalSquare_221 {

    public static void main(String[] args) {
        MaximalSquare_221 maximalSquare = new MaximalSquare_221();
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'}, {'1','0','0','1','0'}};

        System.out.println(maximalSquare.maximalSquare(matrix));
    }


    public int maximalSquare(char[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    maxValue = Math.max(bfs(matrix, i, j), maxValue);
                }
            }
        }

        return maxValue;
    }

    private int bfs(char[][] matrix, int i, int j) {
        Deque<Node> queue = new ArrayDeque<>();
        boolean[][] hasVis = new boolean[matrix.length][matrix[0].length];
        int curValue = 0;
        int[][] directions = {{0,1}, {1,1}, {1,0}};

        queue.addLast(new Node(i,j));

        while (!queue.isEmpty()) {
            int size = queue.size();
            curValue++;
            while (size-- > 0) {
                Node node = queue.removeFirst();
                if (matrix[node.x][node.y] == '0') {
//                    return (curValue - 1)^2;
                    return (int) Math.pow(curValue-1, 2);
                }
                for (int[] d : directions) {
                    int x = d[0] + node.x;
                    int y = d[1] + node.y;

                    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || hasVis[x][y]) {
                        continue;
                    }

                    queue.add(new Node(x, y));
                    hasVis[x][y] = true;
                }
            }
        }

        return (int) Math.pow(curValue, 2);
    }

    static class Node {
        int x ;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
