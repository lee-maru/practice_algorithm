package week02;

/**
 * 문제 출처 : https://www.acmicpc.net/problem/2667
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을,
 * 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고,
 * 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고,
 * 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 * 입력
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고,
 * 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * <p>
 * 출력
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * <p>
 * 예제 입력 1
 * 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 * 예제 출력 1
 * 3
 * 7
 * 8
 * 9
 */

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution23 {
    //좌 우 상 히
    public static int[] dy = {0,0,-1,1};
    public static int[] dx = {-1,1,0,0};
    public static class Node {
        int y; //y좌표
        int x; //x좌표

        public Node(int y, int x) { // 좌표 생성자
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        int N = sc.nextInt(); // N*N N값 입력
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Integer> results = new PriorityQueue<>();
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            String[] split = line.split("");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (graph[y][x] == 1 && !visited[y][x]) {
                    int cnt = 1;
                    q.offer(new Node(y, x));
                    visited[y][x] = true;
                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        int ny = node.y;
                        int nx = node.x;
                        for (int i = 0; i < 4; i++){
                            int yy = ny + dy[i];
                            int xx = nx + dx[i];
                            if (yy >= 0 && xx >= 0 && yy < N && xx < N) {
                                if(graph[yy][xx] == 1 && !visited[yy][xx]){
                                    q.offer(new Node(yy,xx));
                                    visited[yy][xx] = true;
                                    cnt++;
                                }
                            }
                        }
                    }
                    results.offer(cnt);
                }
            }
        }
        System.out.println(results.size());
        while(!results.isEmpty()){
            System.out.println(results.poll());
        }
    }
}
