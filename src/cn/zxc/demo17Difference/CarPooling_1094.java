package cn.zxc.demo17Difference;

public class CarPooling_1094 {

    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 5;
        System.out.println(new CarPooling_1094().carPooling(trips, capacity));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        // 计算站点
        int step = 0;
        for(int[] trip : trips) {
            step = Math.max(step, trip[2]);
        }

        int[] stops = new int[step + 1];

        for(int[] trip : trips) {
            int di = trip[0];
            int i = trip[1];
            int j = trip[2];

            stops[i] += di;
            stops[j] -= di;
        }

        int res = stops[0];
        for(int i = 1; i < stops.length; i++) {
            if(res > capacity) {
                return false;
            }
            res += stops[i];
        }

        return true;
    }
}
