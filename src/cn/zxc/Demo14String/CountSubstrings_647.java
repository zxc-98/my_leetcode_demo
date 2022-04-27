package cn.zxc.Demo14String;

public class CountSubstrings_647 {

    public static void main(String[] args) {
        String s = "aaa";
        CountSubstrings_647 countSubstrings = new CountSubstrings_647();
        System.out.println(countSubstrings.countSubstrings(s));
    }

    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);     // 奇数长度
            extendSubstrings(s, i, i + 1); // 偶数长度
        }
        return cnt;
    }

    private void extendSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }


}
