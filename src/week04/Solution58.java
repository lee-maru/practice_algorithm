package week04;

import java.util.*;

// https://www.acmicpc.net/problem/9095
public class Solution58 {
    public static void main(String[] args) {
        int[] cache;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] TC = new int[K];

        for (int i = 0; i < K; i++) {
            int temp = sc.nextInt();
            if(i == 0){
                max = temp;
            }else{
                if(max < temp)
                    max = temp;

            }
            TC[i] = temp;
        }
        cache = new int[max+1];
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        cache[4] = 7;

        for (int i = 5; i < cache.length; i++) {
            cache[i] = cache[i-1]+cache[i-2]+cache[i-3];
        }

        for (int i = 0; i < TC.length; i++) {
            System.out.println(cache[TC[i]]);
        }
    }
}
