package week04;

import java.util.*;
public class Solution62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][3];
        for (int i = 0; i < N; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
            matrix[i][2] = sc.nextInt();
        }
        for(int i =0; i < N; i++){
            if(i+1 == N)
                break;
            matrix[i+1][0] = Math.min(matrix[i][1] + matrix[i+1][0], matrix[i][2] + matrix[i+1][0]);
            matrix[i+1][1] = Math.min(matrix[i][0] + matrix[i+1][1], matrix[i][2] + matrix[i+1][1]);
            matrix[i+1][2] = Math.min(matrix[i][0] + matrix[i+1][2], matrix[i][1] + matrix[i+1][2]);
        }
        Arrays.sort(matrix[N-1]);
        System.out.println(matrix[N-1][0]);
    }
}