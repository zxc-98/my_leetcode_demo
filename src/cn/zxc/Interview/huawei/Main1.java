package cn.zxc.Interview.huawei;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> title = new HashMap<>();
        HashMap<String, Integer> text = new HashMap<>();

        HashMap<String, Integer> order = new HashMap<>();
        HashSet<String> looks = new HashSet<>();

        int k = 0;

        for(int i = 0; i < 2*m; i++) {
            String s = sc.nextLine();
            String[] words = s.split(" ");

            for(String word : words) {
                looks.add(word);
                if (!order.containsKey(word)) {
                    order.put(word,k++);
                }

                if(i % 2 == 0) {
                    title.put(word, title.getOrDefault(word, 0) + 3);
                }
                else {
                    text.put(word, text.getOrDefault(word, 0) + 1);
                }
            }
        }

        // 优先队列判定规则
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1_title = title.get(o1);
                int o1_text = text.get(o1);
                int o2_title = title.get(o2);
                int o2_text = text.get(o2);
                int k1 = order.get(o1);
                int k2 = order.get(o2);

                // 左边大 小顶堆 堆顶的优先级最小
                if (o1_title + o1_text > o2_title + o2_text) {
                    return 1;
                }
                else if (o1_title + o1_text < o2_title + o2_text) {
                    return -1;
                }
                else {
                    if (o1_title > o2_title) {
                        return 1;
                    }
                    else if (o1_title < o2_title) {
                        return -1;
                    }
                    else {
                        return k2 - k1;
                    }
                }
            }
        });


        for(String look : looks) {
            if (pq.size() < n) {
                pq.add(look);
            }
            else {
                pq.add(look);
                pq.poll();
            }
        }

        Deque<String> queue = new LinkedList<>();

        while (pq.size() > 0) {
            String tmp = pq.poll();
            queue.addLast(tmp);
        }

        for(int i = 0; i < queue.size(); i++) {
            String tmp = queue.removeFirst();
            if(i == n - 1) {
                System.out.print(tmp);
            }
            else {
                System.out.println(tmp + " ");
            }
        }

    }
}
