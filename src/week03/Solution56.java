package week03;

import java.util.*;
public class Solution56 {
    static int maxDistance;
    static int N;
    static boolean[] visited;
    static int endNode;

    static List<List<Node>> matrix = new ArrayList<>();

    static class Node{
        int no;
        int distance;

        public Node(int no, int distance){
            this.no = no;
            this.distance = distance;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt()+1; // node 의 갯수
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < N-2; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            int distance = sc.nextInt();
            matrix.get(node).add(new Node(otherNode, distance));
            matrix.get(otherNode).add(new Node(node, distance));
        }
        visited[1] = true;
        dfs(1,0);

        visited = new boolean[N];
        visited[endNode] = true;
        dfs(endNode,0);

        System.out.println(maxDistance); // 정답 출력

    }

    public static void dfs(int no, int nowDistance){
        if(maxDistance < nowDistance){
            endNode = no;
            maxDistance = nowDistance;
        }
        for (int i = 0; i < matrix.get(no).size(); i++) {
            Node otherNode = matrix.get(no).get(i);
            int otherDistance = otherNode.distance;

            if(!visited[otherNode.no]){
                visited[otherNode.no] = true;
                if(nowDistance == 0){
                    dfs(otherNode.no, otherDistance);
                }else{
                    dfs(otherNode.no, otherDistance + nowDistance);
                }
            }


        }
    }

}
