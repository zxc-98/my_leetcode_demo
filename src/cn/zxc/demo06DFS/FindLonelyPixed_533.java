package cn.zxc.demo06DFS;

import java.util.ArrayList;
import java.util.List;

public class FindLonelyPixed_533 {

    public static void main(String[] args) {
        char[][] p = {{'W', 'B', 'W','B', 'B', 'W'}, {'W', 'B', 'W','B', 'B', 'W'}, {'W', 'B', 'W','B', 'B', 'W'}, {'W', 'W', 'B','W', 'B', 'W'}};
        FindLonelyPixed_533 findLonelyPixed = new FindLonelyPixed_533();
        System.out.println(findLonelyPixed.findLonelyPixed(p,3));
    }

    public int findLonelyPixed (char[][] picture, int N) {
        int ans = 0;
        int n = picture.length;
        int m = picture[0].length;

        List<Integer> h = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B') {
                    cnt++;
                }
            }
            h.add(cnt);
        }

        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (picture[j][i] == 'B') {
                    cnt++;
                }
            }
            l.add(cnt);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B' && h.get(i) == N && l.get(j) == N) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
