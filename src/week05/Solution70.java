package week05;

//https://programmers.co.kr/learn/courses/30/lessons/42586
import java.util.*;
public class Solution70 {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerCopy = new ArrayList<>();

        for(int i =0; i<progresses.length; i++){
            int days = (100 - progresses[i]) / speeds[i];

            if((100 - progresses[i])%speeds[i] != 0)
                days++;

            q.offer(days);
        }

        int beforeDay = q.poll();
        int cnt = 1;

        while(!q.isEmpty()){
            int afterDay = q.poll();
            if(beforeDay >= afterDay){
                cnt++;
            }else{
                answerCopy.add(cnt);
                cnt = 1;
                beforeDay = afterDay;
            }

            if(q.size() == 0)
                answerCopy.add(cnt);
        }

        return answerCopy.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Solution70 s = new Solution70();
        int[] solution = s.solution(progresses, speeds);
        System.out.println();
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]+ " ");
        }
    }
}
