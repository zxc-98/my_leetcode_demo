package cn.zxc.demo02Greedy;

import java.util.Arrays;

/**
 * 小孩分饼干问题：先排序 后使用贪心算法继续分配
 */
public class findContentChildren_455 {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    private static int findContentChildren(int[] g, int[] s) {
        int gi = 0, si = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (gi < g.length && si < s.length) { //贪婪策略 最主要的是先满足胃口小的孩子
            if (s[si] >= g[gi]) {
                gi++;
            }
            si++;
        }

        return gi; //只要满足孩子就可以
    }
}
