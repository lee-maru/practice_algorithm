package week03;

//https://www.acmicpc.net/problem/10026
import java.util.*;

public class Solution48 {
    static String[][][] matrix;
    static boolean[][][] visited;
    static String[] colors = {"R","G","B"};
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int firstResult = 0;
        int secondResult = 0;
        matrix = new String[N][N][2];
        visited = new boolean[N][N][2];

        for (int i = 0; i < N; i++) {
            String next = sc.next();
            String[] split = next.split("");

            for (int j = 0; j < N; j++) {
                String str = split[j];
                matrix[i][j][0] = str;
                if ("R".equals(str) || "G".equals(str)) {
                    matrix[i][j][1] = "RG";
                } else {
                    matrix[i][j][1] = str;
                }
            }
        }

        for (int i = 0; i < colors.length; i++) {
            String color = colors[i];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(matrix[j][k][0].contains(color) && !visited[j][k][0]){
                        visited[j][k][0] = true;
                        firstResult++;
                        dfs(j,k,color,0);
                    }
                    if(matrix[j][k][1].contains(color) && !visited[j][k][1]){
                        visited[j][k][1] = true;
                        secondResult++;
                        dfs(j,k,color,1);
                    }
                }
            }
        }

        System.out.print(firstResult + " " + secondResult);
    }

    static void dfs(int y, int x, String color, int flag){
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>= 0 && ny<N && nx <N){
                if(!visited[ny][nx][flag] && matrix[ny][nx][flag].contains(color)){
                    visited[ny][nx][flag] = true;
                    dfs(ny,nx,color,flag);
                }
            }
        }
    }

}
