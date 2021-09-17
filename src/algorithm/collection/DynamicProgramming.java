package algorithm.collection;

// fibonacci 연습

import java.util.*;
public class DynamicProgramming {
    static long[] cache = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long fib = fibonacci((int) N);
        System.out.println(fib);
    }

    public static long fibonacci(int x){
        if(x == 1 || x == 2)
            return 1;
        if(cache[x] != 0)
            return cache[x];

        return cache[x] = fibonacci(x -1) + fibonacci(x -2);
    }
}
