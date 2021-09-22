package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution78 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Y = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());
        int[][] matrix = new int[Y][X];
        int[][] copyMatrix = new int[Y][X];

        for (int i = 0; i < Y ; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < Y; i++) {

        }
    }
}
