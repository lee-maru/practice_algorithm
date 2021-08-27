package week02;

// https://www.acmicpc.net/problem/7562
import java.util.*;

public class Solution35 {
    static int l;
    static int[] dy ={-1,-2,2,1,-1,-2,2,1};
    static int[] dx ={-2,-1,1,2,2,1,-1,-2};

    static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int MAX = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            Queue<Node> q = new LinkedList<>();

            l = sc.nextInt();
            boolean[][] visited = new boolean[l][l];
            int[][] matrix = new int[l][l];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            matrix[startY][startX] = 1;
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            q.offer(new Node(startY,startX));
            while (!q.isEmpty()){
                Node node = q.poll();
                int y = node.y;
                int x = node.x;
                for (int j = 0; j < 8; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny>=0 && nx>= 0 && ny < l && nx < l){
                        if(!visited[ny][nx] && matrix[ny][nx] == 0){
                            matrix[ny][nx] = matrix[y][x] + 1;
                            visited[ny][nx] = true;
                            q.offer(new Node(ny, nx));
                        }
                    }
                }
            }
            System.out.println(matrix[endY][endX]-1);
        }
    }
}
