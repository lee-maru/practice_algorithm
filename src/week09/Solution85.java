package week09;

import java.util.*;

// https://www.acmicpc.net/problem/1158

public class Solution85 {

    public static void main(String[] args) {
        int N;
        int K;
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 1; i < N+1; i++) {
            q.offer(i);
        }
        System.out.print('<');
        while (!q.isEmpty()){
            for (int i = 0; i < K-1; i++) {
                q.offer(q.poll());
            }
            int poll = q.poll();
            if(q.isEmpty())
                System.out.print(poll);
            else
                System.out.print(poll +", ");
        }
        System.out.print('>');
    }
}
