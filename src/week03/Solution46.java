package week03;

// https://www.acmicpc.net/problem/2468
import java.util.*;

public class Solution46 {
    static int min = 0;
    static int max = 0;
    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = sc.nextInt();
                if(i == 0 && j == 0){
                    min = temp;
                    max = temp;
                }else{
                    if(min > temp){
                        min = temp;
                    }
                    if(max < temp){
                        max = temp;
                    }
                }
                matrix[i][j] = temp;
            }
        }
        for (int rain = min-1; rain <= max; rain++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(matrix[i][j] > rain && !visited[i][j]){
                        cnt++;
                        visited[i][j] = true;
                        dfs(i,j, rain);
                    }
                }
            }
            pq.offer(cnt);
        }
        System.out.println(pq.poll());
    }

    static void dfs(int y, int x, int rain){
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<N && nx<N){
                if(!visited[ny][nx] && matrix[ny][nx] > rain){
                    visited[ny][nx] = true;
                    dfs(ny,nx,rain);
                }
            }
        }
    }

}
