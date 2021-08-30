package week03;
//https://www.acmicpc.net/problem/2606

import java.util.*;
public class Solution42 {
    static int cnt = 0;
    static List<List<Integer>> matrix;
    static boolean[] visited;
    public static void main(String[] args) {
        matrix = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt()+1;
        int E = sc.nextInt();
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
        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int node){
        List<Integer> otherNodes = matrix.get(node);
        for (int i = 0; i < otherNodes.size(); i++) {
            if(!visited[otherNodes.get(i)]){
                visited[otherNodes.get(i)] = true;
                cnt ++;
                dfs(otherNodes.get(i));
            }
        }
    }

}
