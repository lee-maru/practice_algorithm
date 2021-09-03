package week03;

// https://www.acmicpc.net/problem/1937

import java.util.*;

public class Solution55 {
    static int[] dy ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static int N;
    static int cnt = 0;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i,j,visited,1);
            }
        }

        System.out.println(cnt);

    }
    public static void dfs(int y, int x, boolean[][] visited, int result){
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<N && nx<N){
                if(!visited[ny][nx] && matrix[ny][nx] > matrix[y][x]){
                    visited[ny][nx] = true;
                    dfs(ny,nx,visited,result+1);
                    visited[ny][nx] = false;
                }
            }
        }
        cnt = Math.max(result,cnt);
    }


}
