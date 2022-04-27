package cn.zxc.offerBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContinuousSequence_57 {
    public static void main(String[] args) {
        FindContinuousSequence_57 findContinuousSequence = new FindContinuousSequence_57();
        System.out.println(Arrays.deepToString(findContinuousSequence.findContinuousSequence(15)));
    }

    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 2;
        List<int[]> ret = new ArrayList<>();

        while (i < j) {
            int sum = (i + j) * (j - i + 1) / 2;
            if (sum < target) {
                j++;
            } else if (sum > target) {
                i++;
            } else {
                int[] path = createContinuousSequence(i, j);
                ret.add(path);
                i++;
            }
        }
        return ret.toArray(new int[0][]);
    }

    private int[] createContinuousSequence(int i, int j) {
        int[] path = new int[j - i + 1];
        for (int k = 0; k < j - i + 1; k++) {
            path[k] = k + i;
        }
        return path;
    }
}
