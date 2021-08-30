package week03;
//https://www.acmicpc.net/problem/11724

import java.util.*;

public class Solution44 {
    static int V;
    static int E;
    static List<List<Integer>> matrix;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt()+1;
        E = sc.nextInt();
        matrix = new ArrayList<>();
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            matrix.get(node).add(otherNode);
            matrix.get(otherNode).add(node);
        }

        for (int i = 1; i < V; i++) {
            if(!visited[i]){
                cnt++;
                visited[i] = true;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int node){
        for (int i = 0; i < matrix.get(node).size(); i++) {
            int otherNode = matrix.get(node).get(i);
            if(!visited[otherNode]){
                visited[otherNode] = true;
                dfs(otherNode);
            }
        }
    }
}
