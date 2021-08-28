package week02;

// https://www.acmicpc.net/problem/2206

/** // 시간 초과
 * 6 4
 * 0100
 * 1110
 * 1000
 * 0000
 * 0111
 * 0000
 */


import java.util.*;
public class Solution36 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int Y;
    static int X;

    static class Node{
        int y;
        int x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();
        List<Node> oneList = new ArrayList<>();
        int[][] matrix = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            String str = sc.next();
            for (int j = 0; j < X; j++) {
                int i1 = str.charAt(j) - '0';
                matrix[i][j] = i1;
                if(i1 == 1){
                    oneList.add(new Node(i,j));
                }
            }
        }

        int min = 0;
        for (int i = 0; i < oneList.size(); i++) {
            Node node = oneList.get(i);
            matrix[node.y][node.x] = 0;

            int result = bfs(matrix);
            if(i == 0){
                min = result;
            }else{
                if(result != 0){
                    if(min < result){
                        min = result;
                    }
                }
            }

            matrix[node.y][node.x] = 1;
        }

        if(min == 0){
            System.out.println(-1);
            return;
        }

        System.out.println(min);
    }
    static int bfs(int[][] matrix){
        int[][] copyMatrix = new int[Y][X];
        boolean[][] visited = new boolean[Y][X];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        copyMatrix[0][0] = 1;
        q.offer(new Node(0,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < Y && nx < X){
                    if(!visited[ny][nx] && copyMatrix[ny][nx] == 0){
                        visited[ny][nx] = true;
                        copyMatrix[ny][nx] = copyMatrix[y][x] + 1;
                        q.offer(new Node(ny,nx));
                    }
                }
            }
        }

        return copyMatrix[Y-1][X-1];
    }
}
