package week03;

// https://www.acmicpc.net/problem/2573
import java.util.*;
public class Solution54 {
    static int Y;
    static int X;
    static int[][] matrix;
    static int[][] copyMatrix;

    static int[] dy  ={-1,1,0,0};
    static int[] dx ={0,0,-1,1};
    static boolean[][] visited;
    static int year = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();

        matrix = new int[Y][X];
        copyMatrix = new int[Y][X];
        visited = new boolean[Y][X];

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                int ice = sc.nextInt();
                matrix[i][j] = ice;
                copyMatrix[i][j] = ice;
            }
        }
        int ice = (int) 1e9;
        while(true){

            for (int i = 0; i < Y ; i++) {
                for (int j = 0; j < X; j++) {
                    if(!visited[i][j] && matrix[i][j] != 0){
                        searchIce(i,j); // 빙산 갯수 측정
                        ice++;
                    }
                }
            }

            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    matrix[i][j] = copyMatrix[i][j];
                }
            }
            visited = new boolean[Y][X]; // 방문 배열 초기화 시키기
            if(ice > 1){
                System.out.println(year);
                return;
            }
            if(ice == 0){
                System.out.println(0);
                return;
            }
            year++; // 빙산을 녹이고 1년을 증가
        }
    }

    public static void searchIce(int y, int x){
        int waterCnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0&&nx>=0&&ny<Y&&nx<X){
                if(!visited[ny][nx] && matrix[ny][nx]!=0){
                    visited[ny][nx] = true;
                    searchIce(ny,nx);
                }
                if(matrix[ny][nx] == 0){ // 근처 물이 몇개인지 체크
                    waterCnt++;
                }
            }
        }
        copyMatrix[y][x] = Math.max(matrix[y][x] - waterCnt, 0);
    }

}
