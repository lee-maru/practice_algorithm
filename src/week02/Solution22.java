package week02;
/**
 * 문제 출처 : https://www.acmicpc.net/problem/2178
 * N×M크기의 배열로 표현되는 미로가 있다.
 *
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 *
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 *
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 *
 * 예제 입력 1
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution22 {
    // 좌표
    static class Coordinate{
        int x; // x 좌표
        int y; // y 좌표
        //생성자
        public Coordinate(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Queue<Coordinate> q = new LinkedList<Coordinate>();
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 열
        int N = sc.nextInt(); // 행
        int[][] matrix = new int[M][N];
        // 미로 입력 받기
        for (int i = 0; i < M; i++) {
            String s = sc.next();
            String[] split = s.split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        q.offer(new Coordinate(0,0)); // 스타팅 포인 y좌표 0, x 좌표 0 으로 진행
        while (!q.isEmpty()){
            Coordinate coordinate = q.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            int data = matrix[y][x];
            if(y == 0 && x == 0){
                matrix[y][x] = 0;
            }
            if(x!=0 && matrix[y][x-1] == 1){ // 좌측 탐색
                matrix[y][x-1] = data + matrix[y][x-1];
                q.offer(new Coordinate(y, x-1));
            }
            if(y!=0 && matrix[y-1][x] == 1){ // 아래측 탐색
                matrix[y-1][x] = data + matrix[y-1][x];
                q.offer(new Coordinate(y-1, x));
            }
            if(x!=N-1 && matrix[y][x+1] == 1){ // 우측 탐색
                matrix[y][x+1] = data + matrix[y][x+1];
                q.offer(new Coordinate(y, x+1));
            }
            if(y!=M-1 && matrix[y+1][x] == 1){ // 상측 탐색 진행
                matrix[y+1][x] = data + matrix[y+1][x];
                q.offer(new Coordinate(y+1, x));
            }
        }
        System.out.println(matrix[M-1][N-1]);

    }
}
