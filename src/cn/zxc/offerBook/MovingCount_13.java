package cn.zxc.offerBook;

public class MovingCount_13 {

    public static void main(String[] args) {
        int m = 3, n = 1, k = 0;
        MovingCount_13 movingCount = new MovingCount_13();

        System.out.println(movingCount.movingCount(m, n, k));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] hasVisited = new boolean[m][n];
        return searchCount(m, n, k, hasVisited, 0, 0);
    }

    private int searchCount(int m, int n, int k, boolean[][] hasVisited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || hasVisited[i][j] || (i / 100 + i / 10 + i % 10 + j / 100 + j / 10 + j % 10) > k) {
            return 0;
        }

        hasVisited[i][j] = true;


        return searchCount(m, n, k, hasVisited, i, j + 1) + searchCount(m, n, k, hasVisited, i + 1, j) + searchCount(m, n, k, hasVisited, i, j - 1) + searchCount(m, n, k, hasVisited, i - 1, j) + 1;

    }
}
