package cn.zxc.demo03BinarySearch;

public class nextGreatestLetter_744 {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        /* int[] letterNum = new int[len];

        for (int i = 0; i < len; i++) {
            letterNum[i] = letters[i] -'a';
        }

        int targetNum = target -'a';*/

        if (target >= letters[len - 1]) {
            return letters[0];
        } else {//二分查找的变种
            int l = 0;
            int h = len;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (letters[m] <= target) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
            return letters[l];
        }
    }
}
