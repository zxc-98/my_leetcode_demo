package cn.zxc.demo06DFS;

import java.util.ArrayList;
import java.util.List;

public class FindLonelyPixel_531 {

    public static void main(String[] args) {
        char[][] p = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        System.out.println(new FindLonelyPixel_531().findLonelyPixel(p));
    }

    public int findLonelyPixel(char[][] picture) {
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
                if (picture[i][j] == 'B' && h.get(i) == 1 && l.get(j) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
