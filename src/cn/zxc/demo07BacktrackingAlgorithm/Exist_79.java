package cn.zxc.demo07BacktrackingAlgorithm;

public class Exist_79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}};
        String word = "ABCB";
        System.out.println(new Exist_79().exist(board, word));
    }


    private int m, n;
    private final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        if (board == null && board.length == 0 || board[0].length == 0) {
            return false;
        }


        m = board.length;
        n = board[0].length;
        char s = word.charAt(0);

        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(0, board, word, isVisited, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private Boolean search(int k, char[][] board, String word, boolean[][] isVisited, int i, int j) {
        if (k == word.length()) {
            return true;
        }
        char c = word.charAt(k);
        if (i < 0 || i >= m || j < 0 || j >= n || c != board[i][j] || isVisited[i][j]) {
            return false;
        }

        isVisited[i][j] = true;

        for (int[] d : direction) {
            if (search(k + 1, board, word, isVisited, i + d[0], j + d[1])) {
                return true;
            }
        }

        isVisited[i][j] = false;
        return false;
    }
}
