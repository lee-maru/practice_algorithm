package week03;

//https://www.acmicpc.net/problem/4963
import java.util.*;

public class Solution45 {
                    //상 하 좌 우 좌상, 우하, 우상, 좌하
    static int[] dy ={-1,1,0,0,-1,1,-1,1};
    static int[] dx ={0,0,-1,1,-1,1,1,-1};
    static int X;
    static int Y;
    static int[][] matrix;
    static boolean[][] visited;
    static int cnt = 0;
    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){

            X = sc.nextInt();
            Y = sc.nextInt();
            if(X == 0){
                break;
            }
            matrix = new int[Y][X];
            visited = new boolean[Y][X];

            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            cnt = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if(!visited[i][j] && matrix[i][j] == 1){
                        cnt++;
                        visited[i][j] = true;
                        dfs(i,j);
                    }
                }
            }
            results.add(cnt);

        }
        // 정답 출력
        for(int result : results){
            System.out.println(result);
        }
    }

    private static void dfs(int y, int x) {
        for (int i = 0; i < dy.length; i++){
            int ny = y +dy[i];
            int nx = x +dx[i];
            if(ny >= 0 && nx >= 0 && ny < Y && nx < X){
                if(!visited[ny][nx] && matrix[ny][nx] == 1){
                    visited[ny][nx] = true;
                    dfs(ny,nx);
                }
            }
        }
    }
}
