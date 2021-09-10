package week04;

// https://www.acmicpc.net/problem/1912
import java.util.*;
public class Solution66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        int[] cache = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        cache[0] = list[0];
        for (int i = 1; i < cache.length; i++) {
            cache[i] = Math.max(list[i] , cache[i-1] + list[i]);
        }

        Arrays.sort(cache);
        System.out.println(cache[N-1]);
    }
}
