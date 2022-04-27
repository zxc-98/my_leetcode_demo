package cn.zxc.demo02Greedy;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CanPlaceFlowers_605 {
    public static void main(String[] args) {
        int[] flowers = {1, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowers, 2));
    }

    private static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length == 1 && flowerbed[0] ==  0){
            return n <= 1;
        }

        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) {
                continue;
            }

            if((i == 0 && flowerbed[1] != 1) || (i >=1 && flowerbed[i-1] !=1 && i < flowerbed.length - 1 && flowerbed[i+1] != 1) || (i == flowerbed.length -1 && flowerbed[i-1] != 1)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
