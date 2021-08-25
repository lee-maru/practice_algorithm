package week02;

/**
 * 문제 https://www.acmicpc.net/problem/11724
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
 * (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 *
 * 출력
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 */
import java.util.*;

public class Solution28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt()+1; // 노드 갯수
        int K = sc.nextInt(); // 간선 갯수
        int result = 0;
        List<List<Integer>> matrix = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++){
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            matrix.get(node).add(otherNode);
            matrix.get(otherNode).add(node);
        }

        for (int i = 1; i < N; i++){
            Collections.sort(matrix.get(i));
            if(!visited[i]){
                result++;
                q.offer(i);
                Collections.sort(matrix.get(i));
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    for (int j = 0; j < matrix.get(node).size(); j++) {
                        Integer otherNode = matrix.get(node).get(j);
                        if(!visited[otherNode]){
                            visited[otherNode] = true;
                            q.offer(otherNode);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
