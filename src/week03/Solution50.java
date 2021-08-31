package week03;

// https://www.acmicpc.net/problem/11725
import java.util.*;
public class Solution50 {
    static int N;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;

        visited = new boolean[N];
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < N-2; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            matrix.get(node).add(otherNode);
            matrix.get(otherNode).add(node);
        }

        visited[1] = true;
        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node){
        for (int i = 0; i < matrix.get(node).size(); i++) {
            int child = matrix.get(node).get(i);
            if(!visited[child]){
                parent[child] = node;
                visited[child] = true;
                dfs(child);
            }
        }
    }

}
