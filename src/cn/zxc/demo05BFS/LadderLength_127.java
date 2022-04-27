package cn.zxc.demo05BFS;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class LadderLength_127 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new LadderLength_127().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);

        boolean[] hasVis = new boolean[graphic.length];
        hasVis[start] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            while (size-- > 0) {
                Integer cur = queue.removeFirst();
                List<Integer> curList = graphic[cur];
                for (int next : curList) {
                    if (next == end) {
                        return cnt;
                    }

                    if (hasVis[next]) {
                        continue;
                    }
                    hasVis[next] = true;
                    queue.addLast(next);
                }
            }
        }

        return 0;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

}
