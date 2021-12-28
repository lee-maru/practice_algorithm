package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
7
pop
top
push 123
top
pop
top
pop
 */
// https://www.acmicpc.net/problem/10828

public class Solution86 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine());
        String s = br.readLine();
        System.out.println(s);
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println(s2);
        }
    }
    public static void mai1n(String[] args) throws IOException {
        Deque<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int N;
        Scanner sc = new Scanner(System.in);
        N =  sc.nextInt();

        for(int i = 0; i < N; i ++){
            String order = sc.next();
            switch (order){
                case "pop":
                    if(q.isEmpty())
                        result.add(-1);
                    else
                        result.add(q.pollLast());
                    break;
                case "size":
                    result.add(q.size());
                    break;
                case "empty":
                    result.add(q.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    if(q.isEmpty())
                        result.add(-1);
                    else
                        result.add(q.peekLast());
                    break;
                case "push":
                    q.offer(Integer.parseInt(sc.next()));
                    break;
            }
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

}
