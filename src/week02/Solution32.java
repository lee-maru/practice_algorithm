package week02;

import java.util.*;

public class Solution32 {
    static String[] rgb = {"R", "G", "B"};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    static String[][] matrix;

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        int[] results = new int[2];
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            String[] split = str.split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = split[j];
            }
        }

        for (int i = 0; i < 2; i++) {
            int result = bfs(i);
            System.out.print(result + " ");
        }

    }

    private static int bfs(int status) {
        String[][] copyMatrix = new String[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }
        if (status == 0) {
            for (int k = 0; k < rgb.length; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (copyMatrix[i][j].equals(rgb[k]) && !visited[i][j]) {
                            result++;
                            visited[i][j] = true;
                            q.offer(new Node(i, j));
                            while (!q.isEmpty()) {
                                Node node = q.poll();
                                int y = node.y;
                                int x = node.x;
                                for (int l = 0; l < 4; l++) {
                                    int ny = y + dy[l];
                                    int nx = x + dx[l];
                                    if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                                        if (copyMatrix[ny][nx].equals(rgb[k]) && !visited[ny][nx]) {
                                            visited[ny][nx] = true;
                                            q.offer(new Node(ny, nx));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((copyMatrix[i][j].equals(rgb[1]) || copyMatrix[i][j].equals(rgb[0])) && !visited[i][j]) {
                        result++;
                        visited[i][j] = true;
                        q.offer(new Node(i, j));
                        while (!q.isEmpty()) {
                            Node node = q.poll();
                            int y = node.y;
                            int x = node.x;
                            for (int l = 0; l < 4; l++) {
                                int ny = y + dy[l];
                                int nx = x + dx[l];
                                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                                    if ((copyMatrix[ny][nx].equals(rgb[1]) || copyMatrix[ny][nx].equals(rgb[0])) && !visited[ny][nx]) {
                                        visited[ny][nx] = true;
                                        q.offer(new Node(ny, nx));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyMatrix[i][j].equals(rgb[2]) && !visited[i][j]) {
                        result++;
                        visited[i][j] = true;
                        q.offer(new Node(i, j));
                        while (!q.isEmpty()) {
                            Node node = q.poll();
                            int y = node.y;
                            int x = node.x;
                            for (int l = 0; l < 4; l++) {
                                int ny = y + dy[l];
                                int nx = x + dx[l];
                                if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
                                    if (copyMatrix[ny][nx].equals(rgb[2]) && !visited[ny][nx]) {
                                        visited[ny][nx] = true;
                                        q.offer(new Node(ny, nx));
                                    }
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