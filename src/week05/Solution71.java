package week05;

import java.util.*;
public class Solution71 {
    public static void main(String[] args)  {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Solution71 s = new Solution71();
        int solution = s.solution(priorities, location);
        System.out.println(solution);
    }

    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);
        }

        int answer = 0;
        while(!q.isEmpty()){
            int index = q.poll();
            if(check(priorities[index], priorities)){
                q.offer(index);
            }else{
                answer++;
                priorities[index] = 0;
                if(location == index)
                    return answer;
            }
        }
        return answer;
    }
    public boolean check (int prior, int[] priorities){
        for (int priority : priorities) {
            if (prior < priority) {
                return true;
            }
        }
        return false;
    }
}
