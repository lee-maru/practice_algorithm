package week02;

//https://www.acmicpc.net/problem/13460 못품

/**
 * 틀린 반례
 * 7 6
 * ######
 * #.####
 * ##R#.#
 * ##..##
 * #B...#
 * #O####
 * ######
 */

import java.util.*;

public class Solution39 {
    // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int ry;
        int rx;
        int by;
        int bx;
        int cnt;

        public Node() {
        }

        public Node(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;

            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();

        int Y = sc.nextInt();
        int X = sc.nextInt();
        Node startNode = new Node();
        String[][] matrix = new String[Y][X];
        boolean[][][][] visited = new boolean[Y][X][Y][X]; // 0은 red, 1은 blue

        for (int i = 0; i < Y; i++) {
            String s = sc.next();
            String[] split = s.split("");
            for (int j = 0; j < X; j++) {
                String s1 = split[j];
                matrix[i][j] = s1;
                if ("R".equals(s1)) {
                    startNode.ry = i;
                    startNode.rx = j;
                } else if ("B".equals(s1)) {
                    startNode.by = i;
                    startNode.bx = j;
                }
            }
        }

        visited[startNode.ry][startNode.rx][startNode.by][startNode.bx] = true;
        startNode.cnt = 0;
        q.offer(startNode);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int ry = node.ry;
            int rx = node.rx;
            int by = node.by;
            int bx = node.bx;

            if (node.cnt >= 11) {
                System.out.println(-1);
                return;
            }

            if("O".equals(matrix[by][bx])){
                System.out.println(-1);
                return;
            }

            if ("O".equals(matrix[ry][rx])) {
                if (!"O".equals(matrix[by][bx])) {
                    System.out.println(node.cnt);
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                int rny = ry;
                int rnx = rx;
                int bny = by;
                int bnx = bx;

                while (true) {
                    rny = rny + dy[i];
                    rnx = rnx + dx[i];
                    if ("#".equals(matrix[rny][rnx])) {
                        break;
                    }
                    if ("O".equals(matrix[rny][rnx])) {
                        break;
                    }

                }

                if ("#".equals(matrix[rny][rnx])) {
                    rny = rny - dy[i];
                    rnx = rnx - dx[i];
                }

                while (true) {
                    bny = bny + dy[i];
                    bnx = bnx + dx[i];

                    if ("#".equals(matrix[bny][bnx])) {
                        break;
                    }

                    if ("O".equals(matrix[bny][bnx])) {
                        break;
                    }
                } // while 종료

                if ("#".equals(matrix[bny][bnx])) {
                    bny = bny - dy[i];
                    bnx = bnx - dx[i];
                }


                if (rny == bny && bnx == rnx) {
                    if (!"O".equals(matrix[rny][rnx])) {
                        int rt = Math.abs(rny - ry) + Math.abs(rnx - rx);
                        int bt = Math.abs(bny - by) + Math.abs(bnx - bx);
                        if (rt > bt) {
                            rny = rny - dy[i];
                            rnx = rnx - dx[i];
                        } else {
                            bny = bny - dy[i];
                            bnx = bnx - dx[i];
                        }

                    }
                }
                if (!visited[rny][rnx][bny][bnx]) {
                    visited[rny][rnx][bny][bnx] = true;
                    q.offer(new Node(rny, rnx, bny, bnx, node.cnt + 1));
                }
            } // for문 종료

        }
        System.out.println(-1);
    }
}

