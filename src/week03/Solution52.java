package week03;

import java.util.*;

public class Solution52 {
    static int start;
    static int end;
    static int N;
    static int M;
    static boolean result  = false;
    static List<List<Integer>> matrix = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1;
        start = sc.nextInt();
        end = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();

            matrix.get(node).add(otherNode);
            matrix.get(otherNode).add(node);
        }

        visited[start] = true;
        dfs(start, 0);

        if(!result)
            System.out.println(-1);
    }

    static void dfs(int node, int cnt){
        if(node == end){
            System.out.println(cnt);
            result = true;
            return;
        }
        for (int i = 0; i < matrix.get(node).size(); i++) {
            int otherNode = matrix.get(node).get(i);
            if(!visited[otherNode]){
                cnt++;
                visited[otherNode] = true;
                dfs(otherNode,cnt);
                cnt--;
            }
        }
    }
}
