package cn.zxc.Demo14String;

public class longestPalindrome_5 {

    public static void main(String[] args) {
        longestPalindrome_5 longestPalindrome = new longestPalindrome_5();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
    }

    private String ans = "";
    private int len = 0 ;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i+1);
        }

        return ans;
    }

    private void extend(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if(s.substring(start,end+1).length() > len){
                ans = s.substring(start,end+1);
                len = end - start + 1;
            }
            start--;
            end++;
        }
    }
}
