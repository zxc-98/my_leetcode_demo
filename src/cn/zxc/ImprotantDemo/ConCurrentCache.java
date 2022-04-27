package cn.zxc.ImprotantDemo;


import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

// tomcat -- > ConcurrentCache longTerm -- > WeakHashMap
public class ConCurrentCache<K, V> {

    private final Map<K, V> eden;
    private final Map<K, V> longTerm;
    private final int size;

    public ConCurrentCache(int size) {
        this.eden = new ConcurrentHashMap<>();
        this.longTerm = new WeakHashMap<>();
        this.size = size;
    }

    public V get(K key) {

        V v = eden.get(key);

        if (v == null) {
            v = longTerm.get(key);
            if (v != null) {
                eden.put(key, v);//将常用的元素放入eden区域
            }
        }

        return v;
    }

    public void put(K key, V value) {
        if (eden.size() > size) {
            longTerm.putAll(eden);//等待系统自动垃圾回收
            eden.clear();
        }

        eden.put(key, value);
    }
}

class Solution {
    public static void main(String[] args) {
        ConCurrentCache<Integer, Integer> cache = new ConCurrentCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));
    }
}
