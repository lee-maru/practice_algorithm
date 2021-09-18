package algorithm.channelCop;

import java.util.LinkedList;
import java.util.Queue;

import java.util.*;

public class Channel01 {
    public static void main(String[] args) {
        Channel01 s = new Channel01();
        int[][] cars = {{0, 0, 3, 0, 0, 0, 0}, {1, 0, 3, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0, 0}, {0, 0, 2, 0, 0, 3, 3}, {2, 2, 2, 0, 2, 0, 0}, {3, 3, 2, 0, 2, 0, 3}, {3, 3, 2, 0, 2, 0, 4}};
        int solution = s.solution(cars);
        System.out.println(solution);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][][] dist;

    static class Node {
        int x,y,k;

        public Node(int x,int y,int k){
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public int solution(int[][] cars) {
        int k = 0;
        int ly = 0; //목적지 좌표 y
        int lx = 0; //목적지 좌표 x

        int sy = 0; //시작 좌표 y;
        int sx = 0; //시작 좌표 x;


        for (int i = 0; i < cars.length; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (cars[i][j] == 2) {
                    k++;
                }
                if (cars[i][j] == 4) {
                    ly = i;
                    lx = j;
                }
                if(cars[i][j] == 1){
                    sy = i;
                    sx = j;
                }
            }
        }

        dist = new int[cars.length][cars.length][k + 1];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                for (int l = 0; l < k; l++) {
                    dist[i][j][l] = -1;
                }
            }
        }

        Queue<Node> q = new LinkedList<>();

        dist[sy][sx][0] = 1;
        q.add(new Node(sy, sx, 0));
        int result = (int) 1e9;
        while (!q.isEmpty()) {
            Node p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx <0 || nx>= cars.length || ny <0 || ny>= cars.length ) continue;

                if((cars[nx][ny] == 0 && dist[nx][ny][p.k]== -1) || cars[nx][ny] == 4 && dist[nx][ny][p.k]== -1){
                    dist[nx][ny][p.k] = dist[p.x][p.y][p.k] + 1;
                    q.add(new Node(nx,ny,p.k));
                }
                if(cars[nx][ny] == 4){
                    System.out.println(p.k);
                    result = Math.min(result,p.k);
                }

                if(cars[nx][ny] == 2 && p.k+1<=k && dist[nx][ny][p.k+1]==-1){
                    dist[nx][ny][p.k+1] = dist[p.x][p.y][p.k]+1;
                    q.add(new Node(nx,ny,p.k+1));
                }
            }
        }
        if(result != (int) 1e9){
            return result;
        }


        int answer = -1;
        return answer;
    }
}