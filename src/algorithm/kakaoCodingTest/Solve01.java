/**
 *
 */
package algorithm.kakaoCodingTest;
import java.util.*;
public class Solve01 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] reports = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int[] answer = Solve01.solution(id_list, reports, 2);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Integer> map = new HashMap<>();
        HashSet<String> removeReport = new HashSet<>(Arrays.asList(report));
        report = removeReport.toArray(new String[0]);

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String remove = split[1];
            if(map.containsKey(remove)){
                Integer cnt = map.get(remove);
                map.put(remove,cnt+1);
            }else{
                map.put(remove,1);
            }
        }

        for (int i = 0; i < report.length; i++) {
            String[] split = report[i].split(" ");
            String reporter = split[0];
            String remove = split[1];
            if(map.get(remove) >= k){
                for (int j = 0; j < id_list.length; j++) {
                   if(reporter.equals(id_list[j]))
                       answer[j]++;
                }
            }
        }
        return answer;
    }
}
