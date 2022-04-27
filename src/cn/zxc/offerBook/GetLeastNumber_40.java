package cn.zxc.offerBook;

import java.util.Arrays;

public class GetLeastNumber_40 {

    public static void main(String[] args) {
        GetLeastNumber_40 getLeastNumber = new GetLeastNumber_40();
        int[] nums = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int k = 8;
        System.out.println(Arrays.toString(getLeastNumber.getLeastNumbers(nums, k)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1, k);
            quickSort(arr, index + 1, right, k);
        }


    }

    private int getIndex(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && tmp <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && tmp > arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }
}
