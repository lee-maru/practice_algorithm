package week04;

//https://www.acmicpc.net/problem/10870
import java.util.*;
public class Solution60 {
    static int[] cache = new int[20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cache[1] = 1;
        cache[2] = 1;
        System.out.println(fibo(sc.nextInt()));
    }
    static int fibo(int x){
        if(cache[x] != 0 || x==0)
            return cache[x];
        return cache[x] = fibo(x-1) + fibo(x-2);
    }
}
