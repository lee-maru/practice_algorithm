package week02;

// https://www.acmicpc.net/problem/2583

import java.util.*;

public class Solution34 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Y = sc.nextInt();
        int X = sc.nextInt();
        int[][] matrix = new int[Y][X];
        boolean[][] visited = new boolean[Y][X];
        int size = sc.nextInt();
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> results = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int nx = sc.nextInt();
            int ny = sc.nextInt();
            for (int j = y; j < ny; j++) {
                for (int k = x; k < nx; k++) {
                    matrix[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(matrix[i][j] == 0 && !visited[i][j]){
                    int result  = 1;
                    visited[i][j] = true;
                    q.offer(new Node(i,j));
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int y = node.y;
                        int x = node.x;
                        for (int k = 0; k < 4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if(ny >= 0 && nx >= 0 && ny<Y && nx < X){
                                if(matrix[ny][nx] == 0 && !visited[ny][nx]){
                                    visited[ny][nx] = true;
                                    q.offer(new Node(ny,nx));
                                    result++;
                                }
                            }
                        }
                    }
                    results.offer(result);
                }
            }
        }
        System.out.println(results.size());
        while(!results.isEmpty()){
            int result = results.poll();
            System.out.print(result + " ");
        }
    }
}
