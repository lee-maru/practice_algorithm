package week07;
// https://www.acmicpc.net/problem/1316

import java.util.*;
public class Solution79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt = 0;
        String[] question  = new String[T];
        for (int i = 0; i < T; i++) {
            question[i] = sc.next();
        }
        for (String str : question) {
            boolean[] visited = new boolean[127];
            if("year".equals(str)){
                System.out.println("y");
            }
            boolean y = true;

            for (int j = 0; j < str.length(); j++) {
                if (j == str.length() - 1 || str.charAt(j) != str.charAt(j + 1)) {
                    if (visited[str.charAt(j)]) {
                        y = false;
                        break;
                    } else {
                        visited[str.charAt(j)] = true;
                    }
                }
            }

            if (y) {
                System.out.println(str);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
