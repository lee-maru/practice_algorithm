package week04;
//https://www.acmicpc.net/problem/2156

import java.util.*;

public class Solution68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;
        int[] cache = new int[N];
        int[] list = new int[N];
        if(N == 2){
            System.out.println(sc.nextInt());
            return;
        }
        for (int i = 1; i < N; i++) {
            list[i] = sc.nextInt();
        }

        cache[1] = list[1];
        cache[2] = list[1] + list[2];
        for (int i = 3; i < N; i++) {
            int max = 0;
            for (int j = 3; i-j >= 0; j++) {
                int temp = list[i] + list[i - 1] + cache[i - j];
                int temp2 = list[i] + cache[i - (j-1)];
                max = Math.max(temp, Math.max(temp2,max));
            }
            cache[i] = max;
        }
        Arrays.sort(cache);
        System.out.println(cache[N-1]);
    }
}
