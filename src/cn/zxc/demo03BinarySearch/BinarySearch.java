package cn.zxc.demo03BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 6, 7, 9, 11, 11, 22, 600};
        int key = 11;
        System.out.println(binarySearch2(nums, key));//二分查找的算法时间复杂度为O(logN)
    }

    /**
     * 经典二分查找：求有序数组中值的索引位置
     *
     * @param nums
     * @param key
     * @return
     */
    private static int binarySearch1(int[] nums, int key) {//有序的序列才能使用二分查找
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            //如果整型足够大的话 会发生溢出
            //int m = (l+h)/2;
            int m = l + (h - l) / 2;
            if (nums[m] == key) {//如果值相等 返回的是索引
                return m;
            } else if (nums[m] < key) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的变种:在一个有重复元素的数组中查找 key 的最左位置
     *
     * @param nums
     * @param key
     * @return
     */
    private static int binarySearch2(int[] nums, int key) {
        int l = 0;
        int h = nums.length;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < key) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return l;
    }

}


