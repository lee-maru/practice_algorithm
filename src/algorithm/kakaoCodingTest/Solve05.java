package algorithm.kakaoCodingTest;

import java.util.*;

public class Solve05 {
    public static void main(String[] args) {
        int[][] edge = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        int[] info = {0,1,0,1,1,0,1,0,0,1,0};
        Solve05.solution(info, edge);
        System.out.println(sheepCnt);
    }
    static int sheepCnt;
    static int wolfCnt;
    static List<Queue<Integer>> matrix = new ArrayList<>();
    static boolean[] visited;
    static int N;
    public static int solution(int[] info, int[][] edges) {
        sheepCnt = 0;
        wolfCnt = 0;
        N = info.length+1;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            matrix.add(new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][0];
            int otherNode = edges[i][1];
            matrix.get(node).offer(otherNode);
            matrix.get(otherNode).offer(node);
        }
        visited[0] = true;
        sheepCnt++;
        dfs(0, info);

        return sheepCnt;
    }

    public static void dfs(int node, int[] info){
        Queue<Integer> q  = matrix.get(node);
        while (!q.isEmpty()){
            int otherNode = q.poll();
            if(!visited[otherNode] ){
                if( wolfCnt + info[otherNode] < sheepCnt){
                    System.out.println(node + " -> " + otherNode);
                    if(info[otherNode] == 1){
                        wolfCnt++;
                    }else{
                        sheepCnt++;
                    }
                    System.out.println("sheep : " + sheepCnt);
                    System.out.println("wolf : " + wolfCnt);
                    visited[otherNode] =true;
                    dfs(otherNode, info);
                }else{
                    if(q.size() != 0){
                        q.offer(otherNode);
                    }
                }
            }
        }
    }
}

