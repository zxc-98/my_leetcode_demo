package cn.zxc.offerBook;

public class MinArray_11 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        MinArray_11 minArray = new MinArray_11();
        System.out.println(minArray.minArray_2(nums));
    }

    public int minArray_1(int[] numbers) {
        int i = 1;
        while (i < numbers.length && numbers[i] > numbers[i - 1]) {
            i++;
        }
        return numbers[i];
    }

    public int minArray_2(int[] numbers) {
        int l = 0;
        int h = numbers.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (numbers[m] > numbers[h]) {
                l = m + 1;
            } else if (numbers[m] < numbers[h]) {
                h = m;
            } else {
                h--;
            }
        }
        return numbers[l];
    }
}
