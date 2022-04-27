package cn.zxc.offerBook;

//快速排序的应用
public class MinNumber_45 {

    public static void main(String[] args) {
        MinNumber_45 minNumber = new MinNumber_45();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(minNumber.minNumber(nums));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, nums.length - 1);
        StringBuilder ret = new StringBuilder();
        for (String str : strs) {
            ret.append(str);
        }
        return ret.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left < right) {
            int index = getIndex(strs, left, right);
            quickSort(strs, left, index - 1);
            quickSort(strs, index + 1, right);
        }
    }

    private int getIndex(String[] strs, int left, int right) {
        String tmp = strs[left];

        while (left < right) {
            while (left < right && (tmp + strs[right]).compareTo(strs[right] + tmp) <= 0) {
                right--;
            }
            strs[left] = strs[right];

            while (left < right && (tmp + strs[left]).compareTo(strs[left] + tmp) >= 0) {
                left++;
            }
            strs[right] = strs[left];
        }
        strs[left] = tmp;
        return left;
    }
}
