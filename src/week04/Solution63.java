package week04;
// https://www.acmicpc.net/problem/2579
import java.util.*;
public class Solution63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt()+1;
        if(N == 2){
            System.out.println(sc.nextInt());
            return;
        }
        int[] matrix = new int[N];
        int[] cache = new int[N];

        for (int i = 1; i < matrix.length; i++) {
            matrix[i] = sc.nextInt();
        }
        cache[1] = matrix[1];
        cache[2] = matrix[1] + matrix[2];
        for (int i = 3; i < cache.length; i++) {
                cache[i] = Math.max(matrix[i] + matrix[i-1] + cache[i-3], matrix[i] + cache[i-2]);
        }
        System.out.println(cache[N-1]);
    }
}
