package week09;

// https://www.acmicpc.net/problem/2164

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution87 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
