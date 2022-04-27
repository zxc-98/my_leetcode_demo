package cn.zxc.offerBook;

import java.util.*;

public class Permutation_38 {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Arrays.toString(new Permutation_38().permutation(s)));
    }

    public String[] permutation(String s) {

        Set<String> resList = new HashSet<>();
        StringBuilder path = new StringBuilder();
        boolean[] hasVisited = new boolean[s.length()];

        dfs(s, resList, path, hasVisited);

        String[] res = new String[resList.size()];
        int index = 0;
        for (String l : resList) {
            res[index++] = l;
        }
        return res;
    }

    private void dfs(String s, Set<String> resList, StringBuilder path, boolean[] hasVisited) {
        if (path.length() == s.length()) {
            resList.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (hasVisited[i]) continue;
            char curChar = s.charAt(i);
            path.append(curChar);
            hasVisited[i] = true;
            dfs(s, resList, path, hasVisited);
            hasVisited[i] = false;
            path.delete(path.length() - 1, path.length());
        }
    }
}
