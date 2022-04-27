package cn.zxc.demo05BFS;

import java.util.*;

public class LadderLength_127_2 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new LadderLength_127_2().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);

        boolean[] hasVis = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) {
            hasVis[index] = true;
        }


        int path = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (hasVis[i]) {
                        continue;
                    }

                    if (!isConnect(wordList.get(i), cur)) {
                        continue;
                    }

                    if (wordList.get(i).equals(endWord)) {
                        return path;
                    }

                    hasVis[i] = true;
                    queue.addLast(wordList.get(i));
                }
            }
        }

        return 0;
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
