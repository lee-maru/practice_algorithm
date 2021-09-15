package week05;

import java.util.*;
public class Solution76 {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        Solution76 s = new Solution76();
        String[] solution = s.solution(tickets);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            String ticket = tickets[i][0];
            if(!map.containsKey(ticket)){
                map.put(ticket,new ArrayList<>());
            }

            List<String> strings = map.get(ticket);
            strings.add(tickets[i][1]);
            map.put(ticket,strings);

        }

        q.offer("ICN");
        result.add("ICN");

        while (!q.isEmpty()){
            String start = q.poll();
            List<String> others = map.get(start);

            if(others == null)
                break;

            Collections.sort(others);

            for (int i = 0; i < others.size(); i++) {
                if(!"visited".equals(others.get(i))){
                    String otherTicket = others.get(i);
                    q.offer(otherTicket);
                    result.add(otherTicket);
                    others.set(i,"visited");
                }
            }
        }

        return result.toArray(new String[0]);
    }


}