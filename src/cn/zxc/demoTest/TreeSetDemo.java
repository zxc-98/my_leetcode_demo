package cn.zxc.demoTest;
import java.util.*;
public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(null);
        set.add(null);
        set.add(3);
        set.add(4);
        set.add(5);

        for(int s : set){
            System.out.println(s);
        }
    }
}
