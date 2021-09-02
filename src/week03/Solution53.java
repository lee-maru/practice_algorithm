package week03;

// https://www.acmicpc.net/problem/1707
import java.util.*;
public class Solution53 {
    static int K;
    static String[] results;
    static List<List<Integer>> matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        results = new String[K];

        for (int i = 0; i < K ; i++) {
            results[i] = "YES";
        }

        for (int i = 0; i < K; i++) {
            matrix = new ArrayList<>();
            int V = sc.nextInt()+1;
            int E = sc.nextInt();
            boolean[] visited = new boolean[V];
            boolean[] status = new boolean[V];

            for (int j = 0; j < V; j++) {
                matrix.add(new ArrayList<>());
            }
            int max = 0;
            for (int j = 0; j < E; j++) {
                int node = sc.nextInt();
                int otherNode = sc.nextInt();
                int temp = Math.max(node,otherNode);
                if(j == 0){
                    max = temp;
                }else{
                    if(max < temp){
                        max = temp;
                    }
                }
                matrix.get(node).add(otherNode);
                matrix.get(otherNode).add(node);
            }

            for (int j = 1; j < max+1; j++) {
                if(!visited[j]){
                visited[j] = true;
                status[j] = true;
                dfs(j, visited, status, i);
                }
            }

            matrix.clear();
        }

        for(String result : results){
            System.out.println(result);
        }

    }

    static void dfs(int start, boolean[] visited, boolean[] status, int visit){
        for (int i = 0; i < matrix.get(start).size(); i++) {
            int otherNode = matrix.get(start).get(i) ;
            if(!visited[otherNode]){
                visited[otherNode] = true;
                status[otherNode] = !status[start];
                dfs(otherNode, visited, status, visit);
            }else{
                if(status[start] == status[otherNode]){
                    results[visit] = "NO";
                }
            }
        }
    }
}
