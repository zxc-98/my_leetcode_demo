package cn.zxc.demo16SlidingWindow;

public class MaxConsecutiveAnswers_2024 {

    public static void main(String[] args) {
        MaxConsecutiveAnswers_2024 maxConsecutiveAnswers = new MaxConsecutiveAnswers_2024();
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TTFF", 2));
    }

    public int maxConsecutiveAnswers(String answerKey, int k){
        //return Math.max(reverse(answerKey, k, 'T'), reverse(answerKey, k, 'F'));
        return reverse(answerKey, k);
    }

    private int reverse(String answerKey, int k) {
        int n = answerKey.length();
        int r = 0;
        int l = 0;
        int ret = 0;

        int t = 0, f = 0;

        while(r < n) {
            int c = answerKey.charAt(r);
            if (c == 'F') {
                f++;
            }
            else {
                t++;
            }

            while (Math.min(t, f) > k) {
                if (answerKey.charAt(l++) == 'F') {
                    f--;
                }
                else {
                    t--;
                }
            }
            ret = Math.max(ret, r - l + 1);
            r++;
        }

        return ret;
    }
}
