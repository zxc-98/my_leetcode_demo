package cn.zxc.demo02Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class reconstructQueue_406 {
    public static void main(String[] args) {
        int[][] peoples = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = reconstructQueue(peoples);

    }

    public static int[][] reconstructQueue(int[][] people) {
        int N = people.length;

        //首先知道如何去排序 身高降序 个数升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o2[0], o1[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        List<int[]> queue = new ArrayList<>();

        for (int[] p : people) {
            queue.add(p[1], p);//ArrayList对应索引的插入！！！可以扩充 挤掉前后
        }

        return queue.toArray(new int[queue.size()][]);


    }
}
