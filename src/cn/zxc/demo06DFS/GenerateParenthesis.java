package cn.zxc.demo06DFS;
import java.util.*;
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gen = new GenerateParenthesis();
        System.out.println(gen.generateParenthesis(2));
    }


    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, n, n);
        return res;
    }

    private void dfs(ArrayList<String> res, StringBuilder sb, int l, int r) {
        if(l == 0 && r == 0) {
            res.add(sb.toString());
            return;
        }


        if(l > r) {
            return ;
        }

        if(l > 0) {
            sb.append('(');
            dfs(res, sb, l -1, r);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(l > 0) {
            sb.append(')');
            dfs(res, sb, l, r - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
