package cn.zxc.offerBook;

import java.util.*;

public class IsStraight_61 {

    public static void main(String[] args) {
        IsStraight_61 isStraight = new IsStraight_61();
        int[] nums = {0, 0, 2, 3, 6};

        System.out.println(isStraight.isStraight_2(nums));
    }

    public boolean isStraight_1(int[] nums) {
        int Zero = 0;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) {
                Zero++;
            } else {
                list.add(num);
            }
        }
        int[] tmp = new int[list.size()];
        int i = 0;
        for (int l : list) {
            tmp[i++] = l;
        }

        for (int j = 1; j < tmp.length; j++) {
            if (tmp[j] == tmp[j - 1]) {
                return false;
            }
            if (tmp[j] - tmp[j - 1] != 1) {
                Zero -= tmp[j] - tmp[j - 1] - 1;
            }
        }
        return Zero >= 0;
    }

    public boolean isStraight_2(int[] nums) {
        int max = 0;
        int min = 14;
        Set<Integer> set = new HashSet<>();//set集合去重

        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }

            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
        }

        return max - min < 5;
    }


}
