package week03;
// https://www.acmicpc.net/problem/1012
import java.util.*;
public class Solution43 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] matrix;
    static boolean[][] visited;
    static int Y;
    static int X;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // L개의 테스트 케이스
        for (int i = 0; i < L; i++) {
            cnt = 0;
            X = sc.nextInt();
            Y = sc.nextInt();
            matrix = new int[Y][X];
            visited = new boolean[Y][X];
            int Z = sc.nextInt();

            for (int j = 0; j < Z; j++) {
                int zX = sc.nextInt();
                int zY = sc.nextInt();
                matrix[zY][zX] = 1;
            }

            for (int j = 0; j < Y; j++) {
                for (int k = 0; k < X; k++) {
                    if(matrix[j][k] == 1 && !visited[j][k]){
                        visited[j][k] = true;
                        dfs(j,k);
                        cnt++;
                    }
                }
            } // for문 종료
        System.out.println(cnt);
        }
    }
    public static void dfs(int y, int x){
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < Y && nx < X){
                if(matrix[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    dfs(ny,nx);
                }
            }
        }
    }
}
