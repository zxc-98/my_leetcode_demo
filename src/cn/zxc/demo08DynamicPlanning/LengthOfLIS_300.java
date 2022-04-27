package cn.zxc.demo08DynamicPlanning;

public class LengthOfLIS_300 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 5};
        System.out.println(new LengthOfLIS_300().lengthOfLIS_bs(nums));
    }

    public int lengthOfLIS_dp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[]存放前i个最长递增子序列


        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                //在i>j&&nums[j]<nums[i]的条件下,dp[i]=Math.max(1,dp[j]+1)
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }


    public int lengthOfLIS_bs(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;

        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;//更新或在尾部添加
            if (len == index) {//说明tails[]添加了新的数字在尾部,tails[]长度+1
                len++;
            }
        }
        return len;
    }

    //获取指定元素在tails[]中的位置
    private int binarySearch(int[] tails, int len, int key) {
        int l = 0;
        int h = len;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
