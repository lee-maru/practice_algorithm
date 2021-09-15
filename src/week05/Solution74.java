package week05;

// https://programmers.co.kr/learn/courses/30/lessons/43162
import java.util.*;
public class Solution74 {
    public static void main(String[] args) {
        Solution74 s = new Solution74();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(s.solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int k = 0; k < n; k++) {
            Queue<Integer> q = new LinkedList<>();
            if(!visited[k]){
                answer++;
                q.offer(k);
                visited[k] = true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for (int i = 0; i < n; i++) {
                        int otherNode = computers[node][i];
                        if(!visited[i] && otherNode == 1){
                            if(i != node){
                                visited[i] = true;
                                q.offer(i);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

}
