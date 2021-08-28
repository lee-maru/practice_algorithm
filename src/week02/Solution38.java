package week02;

// https://www.acmicpc.net/problem/2644

/**
 * 9
 * 7 3
 * 7
 * 1 2
 * 1 3
 * 2 7
 * 2 8
 * 2 9
 * 4 5
 * 4 6
 */

import java.util.*;

public class Solution38 {
    public static class Node{
        int no;
        int cnt;
        Node(int no, int cnt){
            this.no = no;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // vertex
        int start = sc.nextInt(); // 7
        int end = sc.nextInt(); // 3
        int E = sc.nextInt(); // edge
        boolean[] visited = new boolean[N+1];
        Queue<Node> q = new LinkedList<>();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            matrix.add(new ArrayList<>()); // 촌수 matrix 초기화
        }

        // 촌수 관계 맺어줌
        for (int i = 0; i < E; i++) {
            int node = sc.nextInt();
            int otherNode = sc.nextInt();

            matrix.get(node).add(otherNode);
            matrix.get(otherNode).add(node);
        }
        Node startNode = new Node(start, 0);
        q.offer(startNode);
        visited[startNode.no] = true;
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.no == end){
                System.out.println(node.cnt);
                return;
            }
            for (int i = 0; i < matrix.get(node.no).size(); i++) {
                int otherNodeNo = matrix.get(node.no).get(i);
                if(!visited[otherNodeNo]){
                    Node node1 = new Node(otherNodeNo, node.cnt + 1);
                    q.offer(node1);
                    visited[node1.no] = true;
                }
            }
        }
        System.out.println(-1);
    }
}
