package week04;

import java.util.*;

public class Solution65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] matrix = new int[N];
        int[] cache = new int[N];
        for (int i = 0; i < N; i++) {
            matrix[i] = sc.nextInt();
        }
        cache[0] = 1;
        for (int i = 1; i < N; i++) {
            int temp = matrix[i];
            int cnt = 0;
            for (int j = i; j >= 0; j--) {
                if(matrix[j] < temp){
                    cnt = Math.max(cache[j],cnt);
                }
            }
            if(cnt != 0)
                cache[i] = cnt+1;
            else
                cache[i] = 1;
        }
        Arrays.sort(cache);
        System.out.println(cache[N-1]);
    }
}
