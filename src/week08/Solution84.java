package week08;
// https://www.acmicpc.net/problem/10610

import java.util.*;

public class Solution84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String contain = sc.next();

            if(!arr.contains(contain))
                arr.add(contain);
        }
        arr.stream().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo)).forEach(System.out::println);
    }
}
