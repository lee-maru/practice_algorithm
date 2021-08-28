package week02;

// https://www.acmicpc.net/problem/11725
import java.util.*;

public class Solution37 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 노드 갯수
        boolean[] visited = new boolean[N+1]; // 방문 확인
        int[] parent = new int[N+1];
        Queue<Integer> q = new LinkedList<>(); // 큐
        List<Integer>[] matrix = new ArrayList[N+1];

        for (int i = 0; i < matrix.length; i++) { // 자식노드를 담을 리스트 초기화 진행
            matrix[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int motherNode = sc.nextInt();
            int parentNode = sc.nextInt();
            matrix[motherNode].add(parentNode);
            matrix[parentNode].add(motherNode);
        }

        q.offer(1);
        while(!q.isEmpty()){
            int parentNode = q.poll();
            visited[parentNode] = true;
            for (int i = 0; i < matrix[parentNode].size(); i++) {
                int child = matrix[parentNode].get(i); // 자식 꺼내기
                if(!visited[child]){
                    visited[child] = true; // 부모를 찾은 노드는 방문하지 않는다.
                    parent[child] = parentNode; // 자식 부모(parentNode) 인걸 넣어주기
                    q.offer(child); // child 자식의 부모를 찾아주도록 한다.
                }
            }
        }

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}
