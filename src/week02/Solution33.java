package week02;
// https://www.acmicpc.net/problem/7569

import java.util.*;
public class Solution33 {
    static int[] dh ={-1,1,0,0,0,0};
    static int[] dy ={0,0,-1,1,0,0};
    static int[] dx ={0,0,0,0,-1,1}; //6

    public static class Node{ //좌표
        int h;
        int y;
        int x;
        public Node(int h, int y, int x){
            this.h =h;
            this.y =y;
            this.x =x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int H = sc.nextInt();
        Queue<Node> q = new LinkedList<>();
        int[][][] matrix = new int[H][Y][X];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    int tomato = sc.nextInt();
                    matrix[i][j][k] = tomato;
                }
            }
        }

        boolean[][][] visited = new boolean[H][Y][X];

        for (int i = 0; i < H; i++) { // 높이 조회
            for (int j = 0; j < Y; j++) { // 열 조회
                for (int k = 0; k < X; k++) { // 행 조회
                    if(!visited[i][j][k] && matrix[i][j][k] == 1){
                        visited[i][j][k] = true;
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();
            int h = node.h;
            int y = node.y;
            int x = node.x;
            for (int l = 0; l < 6; l++) {
                int nh = h + dh[l];
                int ny = y + dy[l];
                int nx = x + dx[l];
                if(nh >= 0 && ny >= 0 && nx >= 0 && nh < H && ny < Y && nx < X){
                    if(!visited[nh][ny][nx] && matrix[nh][ny][nx]==0){
                        visited[nh][ny][nx] = true; // 방문 처리
                        matrix[nh][ny][nx] = matrix[h][y][x] + 1; // 하루 지낭
                        q.offer(new Node(nh, ny, nx)); // Queue 삽입
                    }
                }
            }
        }

        int result = matrix[0][0][0];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    int day = matrix[i][j][k];
                    if (result < day) {
                        result = day;
                    }
                    if (day == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result-1);
    }
}
