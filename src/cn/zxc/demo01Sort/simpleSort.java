package cn.zxc.demo01Sort;

public class simpleSort {
    public void Sort1(int[] nums) { //冒泡排序
        int N = nums.length;
        Boolean isSorted = false;

        for (int i = N - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j + 1] < nums[j]) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] num, int u, int v) {
        int k = num[u];
        num[u] = num[v];
        num[v] = k;
    }


    public void Sort2(int[] nums) { //选择排序
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void Sort3(int[] nums) { //插入排序
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) { // 只有前面比后面大才需要交换
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    public void Sort4(int[] nums) { //希尔排序
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // h = 1 4 13
        }


        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (nums[j] < nums[j - h]) { // 只有前面比后面大才需要交换
                        swap(nums, j, j - h);
                    }
                }
            }

            h = h / 3;
        }

    }


}
