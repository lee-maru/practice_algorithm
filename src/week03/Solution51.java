package week03;

import java.util.*;

public class Solution51 {
    static int[] dy ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static int Y;
    static int X;
    static int[][] matrix;
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        matrix = new int[Y][X];
        visited = new boolean[Y][X];
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        visited[0][0] = true;
        dfs(0,0, visited);

        System.out.println(result);
    }

    static void dfs(int y, int x, boolean[][] visited){
        boolean[][] copyVisited = visited.clone();
        if(y == Y-1 && x == X-1){
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < Y && nx < X){
                if(!copyVisited[ny][nx] && matrix[y][x] > matrix[ny][nx]){
                    copyVisited[ny][nx] = true;
                    dfs(ny,nx,copyVisited);
                    copyVisited[ny][nx] = false;
                }
            }
        }


    }
}
