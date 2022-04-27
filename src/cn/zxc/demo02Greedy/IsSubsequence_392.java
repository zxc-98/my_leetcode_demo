package cn.zxc.demo02Greedy;

/**
 * 和小孩吃饼干属于同一类问题
 */
public class IsSubsequence_392 {
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        int Si = 0, Ti = 0;
        while (Si < s.length() && Ti < t.length()) {
            if (s.charAt(Si) == t.charAt(Ti)) {
                Si++;
            }
            Ti++;
        }
        return Si == s.length();
    }
}
