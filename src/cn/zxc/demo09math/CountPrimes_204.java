package cn.zxc.demo09math;

//小于非负整数 n 的质数的数量
public class CountPrimes_204 {

    public static void main(String[] args) {
        System.out.println(countPrimes2(49979));
    }

    private static int countPrimes1(int n) {
        int primes = 0;

        for (int i = 2; i < n; i++) {
            int count = 0;//判断是否有因式
            for (int j = i; j >= 2; j--) {
                if (i % j == 0 && i != j) {
                    count++;
                }
            }

            if (count == 0) {//没有除本身之外的因数 就是质数
                primes++;
            }
        }

        return primes;
    }


    private static int countPrimes2(int n) {
        int primes = 0;
        boolean[] notPrime = new boolean[n + 1];//不是质数的集合

        for (int i = 2; i < n; i++) {
            if (notPrime[i]) {//如果不是质数
                continue;
            }

            primes++;
            for (long j = (long) (i) * i; j < n; j += i) {//例如 i=2时 4 6 8 都不是质数 i=3 时 9不是质数 12 15 18 也不是质数 i=4 时 16 20 不是质数
                notPrime[(int) j] = true;
            }
        }

        return primes;
    }
}
