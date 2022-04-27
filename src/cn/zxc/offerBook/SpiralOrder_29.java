package cn.zxc.offerBook;

import java.util.Arrays;

public class SpiralOrder_29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder_29 spiralOrder = new SpiralOrder_29();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
    }

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[m * n];

        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        int x = 0;

        while (true) {
            for (int i = left; i <= right; i++) {
                ret[x++] = matrix[up][i];
            }


            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ret[x++] = matrix[i][right];
            }


            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ret[x++] = matrix[down][i];
            }
            down--;
            if (down < up) {
                break;
            }

            for (int i = down; i >= up; i--) {
                ret[x++] = matrix[i][left];
            }

            left++;
            if (right < left) {
                break;
            }

        }
        return ret;
    }
}
