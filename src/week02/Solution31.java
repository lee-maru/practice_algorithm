package week02;

// 문제 출처 : https://www.acmicpc.net/problem/2468
import java.util.*;
public class Solution31 {
    static int MAX = 101;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int N;
    static int[][] matrix; // 지도

    public static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        PriorityQueue<Integer> homes = new PriorityQueue<>(Comparator.reverseOrder());
        matrix = new int[N][N];
        int lengthMax = 0;
        int lengthMin = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int length = sc.nextInt();
                if(i == 0 && j == 0){
                    lengthMin = length;
                }

                if(length > lengthMax) { // 최대 건물높이
                    lengthMax = length;
                }

                if(length < lengthMin){ // 최소 건물 높이
                    lengthMin = length;
                }
                matrix[i][j] = length;
            }
        }

        for(int i=0; i<MAX; i++){
            if(i < lengthMin){ // 비가 안내린 경우 & 제일 작은 높이의 건물보다 강수량이 적을 경우
                homes.offer(1);
            }else if(i >= lengthMax) { // 비가 너무 낳이 와서 제일 높은 건물보다 강수량이 많을 경우
                homes.offer(0);
                break; // 지속적으로 비가 많이 올 수 있으니 종료
            } else{
                homes.offer(bfs(i));
            }
        }

        System.out.println(homes.poll());
    }

    private static int bfs(int max) {

        int result = 0;
        boolean[][] visited = new boolean[N][N];
        int[][] copyMap = new int[N][N];
        Queue<Node> q = new LinkedList<>();

        // 현재 집을 똑같이 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(copyMap[i][j] > max && !visited[i][j]){
                    result++;
                    q.offer(new Node(i,j));
                    visited[i][j]= true;
                    while (!q.isEmpty()){
                        Node node = q.poll();
                        int yy = node.y;
                        int xx = node.x;
                        for (int k = 0; k < 4; k++) {
                            int ny = yy + dy[k];
                            int nx = xx + dx[k];
                            if(ny>=0 && nx>=0 && nx<N && ny<N){
                                if (!visited[ny][nx] && copyMap[ny][nx] > max){
                                    q.offer(new Node(ny,nx));
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
