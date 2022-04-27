package cn.zxc.offerBook;

public class ReplaceSpace_05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        ReplaceSpace_05 replaceSpace = new ReplaceSpace_05();
        System.out.println(replaceSpace.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder ret = new StringBuilder();
        int leftInd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ret.append(s, leftInd, i).append("%20");
                leftInd = i + 1;
            }
        }
        return ret + s.substring(leftInd);
    }
}
