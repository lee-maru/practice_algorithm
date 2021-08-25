package week02;

/**
 * 문제
 * 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
 * w와 h는 50보다 작거나 같은 양의 정수이다.
 *
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
 *
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 *
 * 출력
 * 각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
 *
 * 예제 입력 1
 * 1 1
 * 0
 * 2 2
 * 0 1
 * 1 0
 * 3 2
 * 1 1 1
 * 1 1 1
 * 5 4
 * 1 0 1 0 0
 * 1 0 0 0 0
 * 1 0 1 0 1
 * 1 0 0 1 0
 * 5 4
 * 1 1 1 0 1
 * 1 0 1 0 1
 * 1 0 1 0 1
 * 1 0 1 1 1
 * 5 5
 * 1 0 1 0 1
 * 0 0 0 0 0
 * 1 0 1 0 1
 * 0 0 0 0 0
 * 1 0 1 0 1
 * 0 0
 * 예제 출력 1
 * 0
 * 1
 * 1
 * 3
 * 1
 * 9
 */
import java.util.*;

public class Solution30 {
                    //상,하,좌,우,대각 방향
    static int[] dy ={-1,1,0,0,-1,1,-1,1};
    static int[] dx ={0,0,-1,1,1,-1,-1,1};
    // 노드 위취
    static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            Queue<Node> q = new LinkedList<>();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            if(Y == 0 || X == 0){ // 0 0 입력되면 종료
                break;
            }
            int[][] matrix = new int[Y][X];
            boolean[][] visited = new boolean[Y][X];
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int result = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if(!visited[i][j] && matrix[i][j] == 1){ // 최초 섬 발견!
                        result ++; // 섬발견 했으니 result + 1 증가
                        q.offer(new Node(i,j));
                        visited[i][j] = true;
                        while (!q.isEmpty()){
                            Node node = q.poll();
                            int y = node.y;
                            int x = node.x;
                            for (int k = 0; k < 8; k++) { // 8개의 방향으로 순회
                                int ny = y + dy[k];
                                int nx = x + dx[k];
                                if(ny >= 0 && nx >= 0 && ny < Y && nx <X && !visited[ny][nx] && matrix[ny][nx] == 1){
                                    visited[ny][nx] = true;
                                    q.offer(new Node(ny,nx));
                                }
                            }
                        }
                    }
                }
            }
            results.add(result);
        }
        for (Integer result : results) {
            System.out.println(result);
        }

    }
}
