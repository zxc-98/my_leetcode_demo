package cn.zxc.offerBook;

public class MissingNumber_53 {

    public static void main(String[] args) {
        MissingNumber_53 missingNumber = new MissingNumber_53();
        int[] nums = {0, 2};
        System.out.println(missingNumber.missingNumber(nums));
    }


    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int l = 0;
        int h = nums.length - 1;
        if (nums[h] == h) return h + 1;

        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }
}
