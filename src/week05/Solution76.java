package week05;

import java.util.*;

//{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}}
//{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
//{{"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}, {"A" , "C"}}
public class Solution76 {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}};
        Solution76 s = new Solution76();
        String[] solution = s.solution(tickets);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }

    static Map<String, List<String>> map = new HashMap<>();
    static List<String> results = new ArrayList<>();
    static String beforeNode = "ICN";

    public String[] solution(String[][] tickets) {

        for (int i = 0; i < tickets.length; i++) {
            String ticket = tickets[i][0];
            if (!map.containsKey(ticket)) {
                map.put(ticket, new ArrayList<>());
            }

            List<String> strings = map.get(ticket);

            strings.add(tickets[i][1]);

            map.put(ticket, strings);
        }
        dfs("ICN", 0, tickets.length + 1);

        return results.toArray(new String[0]);
    }

    public boolean check(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!"visited".equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void dfs(String node, int cnt, int max) {

        results.add(node);
        List<String> otherNodes = map.get(node); // 현재 티켓으로 갈 수 있는 다른 티켓을 뽑아냄
        Collections.sort(otherNodes); // 정렬 진행
        System.out.println(node + " -> " + otherNodes);
        for (int i = 0; i < otherNodes.size(); i++) {
            if (!"visited".equals(otherNodes.get(i))) {
                otherNodes.set(i, "visited");
            }
        }
    }
}
