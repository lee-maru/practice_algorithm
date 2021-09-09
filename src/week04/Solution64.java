package week04;

import java.util.*;
public class Solution64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];
        int[][] cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        cache[0][0] = matrix[0][0];

        for (int i = 1; i < N; i++) {
            for(int j=0; j<matrix[i].length; j++){
                if(j == 0){
                    cache[i][j] = matrix[i][j] + cache[i-1][j];
                }else if(j == matrix[i].length){
                    cache[i][j] = matrix[i][j] + cache[i-1][j-1];
                }else{
                    cache[i][j] = Math.max(matrix[i][j] + cache[i-1][j-1], matrix[i][j] + cache[i-1][j]);
                }
            }
        }
        int[] results = cache[N-1];
        Arrays.sort(results);
        System.out.println(results[results.length-1]);
    }
}
