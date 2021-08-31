package week03;

// https://www.acmicpc.net/problem/2583
import java.util.*;

public class Solution49 {
    static int Y;
    static int X;
    static int C;
    static int[] dy ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static int[][] matrix;
    static int result = 0;
    static boolean[][] visited;
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    static int cnt =  0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        matrix = new int[Y][X];
        visited = new boolean[Y][X];
        C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            int[] rectangle = new int[4];
            for (int j = 0; j < rectangle.length; j++) {
                rectangle[j] = sc.nextInt();
            }
            for (int j = rectangle[1]; j < rectangle[3]; j++){
                for (int k = rectangle[0]; k < rectangle[2]; k++) {
                    matrix[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if(!visited[i][j] && matrix[i][j] == 0){
                    visited[i][j] = true;
                    cnt = 1;
                    result++;
                    dfs(i,j);
                    q.offer(cnt);
                }
            }
        }
        System.out.println(result);
        while(!q.isEmpty()){
            System.out.print(q.poll() + " ");
        }
    }

    static void dfs(int y, int x){
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny <Y && nx < X){
                if(matrix[ny][nx]==0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    cnt++;
                    dfs(ny,nx);
                }
            }
        }
    }

}
