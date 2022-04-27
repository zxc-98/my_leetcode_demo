package cn.zxc.Interview.wangyi;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public int stat_hit_count (int[] R, int N) {
        // write code here
        LRUCache lruCache = new LRUCache(N);
        for (int r : R) {
            if (lruCache.get(r) == -1) {
                lruCache.put(r, -1);
            }
        }
        return lruCache.count;
    }

    static class LRUCache extends LinkedHashMap<Integer,Integer> {
        public int capacity;
        public int count = 0;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (super.containsKey(key)) {
                count++;
                return super.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
