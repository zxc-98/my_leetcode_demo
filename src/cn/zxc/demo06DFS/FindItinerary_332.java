package cn.zxc.demo06DFS;


import java.util.*;

public class FindItinerary_332 {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("JFK");
        t1.add("KUL");

        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("NRT");

        List<String> t3 = new ArrayList<>();
        t3.add("NRT");
        t3.add("JFK");

//        List<String> t4 = new ArrayList<>();
//        t4.add("ATL");
//        t4.add("JFK");
//
//        List<String> t5 = new ArrayList<>();
//        t5.add("ATL");
//        t5.add("SFO");


        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
//        tickets.add(t4);
//        tickets.add(t5);

        System.out.println(new FindItinerary_332().findItinerary(tickets));
    }

    private Map<String, PriorityQueue<String>> graphic = new HashMap<>();
    private Stack<String> stack = new Stack<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            if (graphic.get(ticket.get(0)) == null) {
                graphic.put(ticket.get(0), new PriorityQueue<>());
            }

            graphic.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");

        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    private void dfs(String cur) {
        while (graphic.get(cur) != null && !graphic.get(cur).isEmpty()) {
            String p = graphic.get(cur).poll();
            dfs(p);
        }

        stack.push(cur);
    }
}
