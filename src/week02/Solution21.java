package week02;

/**
 * https://www.acmicpc.net/problem/1260
 * 문제
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * 출력
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 *
 * 예제 입력 1
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 * 예제 출력 1
 * 1 2 4 3
 * 1 2 3 4
 * 예제 입력 2
 * 5 5 3
 * 5 4
 * 5 2
 * 1 2
 * 3 4
 * 3 1
 * 예제 출력 2
 * 3 1 2 5 4
 * 3 1 4 2 5
 */
import java.util.*;

public class Solution21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드의 갯수 입력
        int M = sc.nextInt(); // 간선의 갯수 입력
        List<List<Integer>> graph = new ArrayList<>(new ArrayList<>());
        boolean[] dfsVisited = new boolean[N+1]; // DFS 를 위한 방문 배열
        boolean[] bfsVisited = new boolean[N+1]; // DFS 를 위한 방문 배열
        Queue<Integer> queue = new LinkedList<>(); // BFS Queue 생성
        int start = sc.nextInt(); // 시작하는 노드 입력
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            graph.add(new ArrayList<>());
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            graph.get(node).add(otherNode);
            graph.get(otherNode).add(node);
        }
        // dfs 실행
        dfs(start, graph, dfsVisited);
        // 분기
        System.out.println();
        // bfs 실행
        bfs(start, graph, queue, bfsVisited);

    }

    public static void bfs(int start, List<List<Integer>> graph, Queue<Integer> queue, boolean[] visited){
        // 처음 start 노드를 큐에 삽입함
        queue.offer(start);
        // 처음 start 노드를 방문함.
        visited[start] = true;

        while(!queue.isEmpty()){
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i < graph.get(start).size(); i++) {
                Integer otherNode = graph.get(start).get(i);
                if(!visited[otherNode]){
                    visited[otherNode] = true;
                    queue.offer(otherNode);
                }
            }
        }
    }

    public static void dfs(int start, List<List<Integer>> graph, boolean[] visited){
        if(!visited[start]){
            System.out.print(start + " ");
            visited[start] = true;
        }
        Collections.sort(graph.get(start));
        for (int i = 0; i < graph.get(start).size(); i++) {
            Integer otherStart = graph.get(start).get(i);
            if(!visited[otherStart]){
                dfs(otherStart, graph, visited);
            }
        }
    }
}
