package week03;

//https://www.acmicpc.net/problem/1987
import java.util.*;
public class Solution47 {
    static int[] dy ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static int Y;
    static int X;
    static int result = 1;
    static char[][] matrix;
    public static void main(String[] args) {
        boolean[] visited = new boolean[26]; // 알파벳 갯수는 총 26개 - 1 이니 25개
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        matrix = new char[Y][X];
        int start = 0;
        for (int i = 0; i < Y; i++) {
            String str = sc.next();
            for (int j = 0; j < X; j++) {
                char c = str.charAt(j);
                matrix[i][j] = (char) ( c -'A');
                if(i == 0 && j == 0){
                    start = matrix[i][j];
                }
            }
        }

        visited[start]=true;
        dfs(0,0,visited, 1);
        System.out.println(result);
    }

    static void dfs(int y, int x, boolean[] visited, int cnt){
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >= 0 &&  ny < Y && nx < X){
                int ix = matrix[ny][nx];
                if(!visited[ix]){
                    visited[ix] = true;
                    if(++cnt > result){
                        result = cnt;
                    }
                    dfs(ny,nx,visited,cnt);
                    visited[ix] = false;
                    --cnt;
                }
            }
        }
    }
}
