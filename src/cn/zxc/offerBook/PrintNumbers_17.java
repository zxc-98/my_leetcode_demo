package cn.zxc.offerBook;

public class PrintNumbers_17 {
    public static void main(String[] args) {
        PrintNumbers_17 printNumbers = new PrintNumbers_17();
        System.out.println(printNumbers.printNumbers_2(2));
    }

    public int[] printNumbers(int n) {
        int[] ret = new int[(int) Math.pow(10,n)];

        for(int i=0 ; i < Math.pow(10,n)-1 ;i++){
            ret[i] = i+1;
        }

        return ret;
    }

    //考虑大数问题 考虑全排列
    private int n ;
    private StringBuilder ret ;
    private int start ;//初始化左边界为n-1
    private int nine = 0 ;//开始的9
    private char[] nums , loop = {'0','1','2','3','4','5','6','7','8','9'};
    public String printNumbers_2(int n) {
        this.n = n ;
        nums = new char[n];
        start = n - 1 ;
        ret = new StringBuilder();
        dfs(0);//对数字进行全排列
        ret.delete(ret.length()-1,ret.length());
        return ret.toString();
    }

    private void dfs(int i) {
        if (i == n){
            String s = String.valueOf(nums).substring(start);
            if (!s.equals("0")) ret.append(s).append(',');
            if (n-start == nine){ // n-左边界 == 第nine个9
                start--;// 左边界--
            }
            return ;
        }

        for (char l : loop) {
            if (l=='9'){
                nine++;
            }
            nums[i] = l ;
            dfs(i+1);
        }
        nine--;//回溯前恢复 nine = nine - 1nine=nine−1

    }
}
