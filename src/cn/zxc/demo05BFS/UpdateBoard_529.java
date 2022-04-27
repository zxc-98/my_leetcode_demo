package cn.zxc.demo05BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class UpdateBoard_529 {
    int[][] addOne = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    boolean[][] hasVis;
    int n,m;
    public char[][] updateBoard(char[][] board, int[] click) {
        n = board.length;
        m = board[0].length;
        int clickX = click[0];
        int clickY = click[1];
        if(board[clickX][clickY] == 'M') {
            board[clickX][clickY] = 'X';
            return board;
        }
        else {
            hasVis = new boolean[n][m];
            hasVis[clickX][clickY] = true;
            bfs(board,clickX,clickY);
        }

        return board;
    }

    private void bfs(char[][] board, int clickI, int clickJ) {

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(clickI, clickJ));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int cnt = 0;
            for (int[] next : addOne) {
                int nextX = next[0];
                int nextY = next[1];

                int i = nextX + curNode.x;
                int j = nextY + curNode.y;

                if (i < 0 || i >= n || j < 0 || j >= m) {
                    continue;
                }

                if (board[i][j] == 'M') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                board[curNode.x][curNode.y] = (char) (cnt + '0');
            }
            else {
                board[curNode.x][curNode.y] = 'B';
                for (int[] next : addOne) {
                    int nextX = next[0];
                    int nextY = next[1];

                    int i = nextX + curNode.x;
                    int j = nextY + curNode.y;
                    if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'E' || hasVis[i][j]) {
                        continue;
                    }
                    queue.add(new Node(i, j));
                    hasVis[i][j] = true;
                }
            }
        }
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
