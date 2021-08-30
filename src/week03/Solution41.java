package week03;

import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/2667
public class Solution41 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] matrix;
    static int N;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String next = sc.next();
            String[] split = next.split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && matrix[i][j] == 1){
                    cnt = 1;
                    result++;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(result);
        Collections.sort(list);
        for(int i : list){
            System.out.println(i);
        }
    }

    public static void dfs(int i, int j){
        for (int k = 0; k < 4; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if(y >= 0 && x >= 0 && y < N && x <N){
                if(!visited[y][x] && matrix[y][x] == 1){
                    cnt++;
                    visited[y][x] = true;
                    dfs(y,x);
                }
            }
        }
    }
}
