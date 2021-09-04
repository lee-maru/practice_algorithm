package week03;

import java.util.*;
public class Solution56 {
    static int distance;
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
        N = sc.nextInt(); // node 의 갯수
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();
            int distance = sc.nextInt();
            matrix.get(node).add(new Node(otherNode, distance));
            matrix.get(otherNode).add(new Node(node, distance));
        }

    }
    public static void dfs(int no, int nowDistance){
        for (int i = 0; i < matrix.get(no).size(); i++) {
            Node otherNode = matrix.get(no).get(i);
            nowDistance = otherNode.distance;
        }
    }
}
