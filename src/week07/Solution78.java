package week07;

import java.util.*;
public class Solution78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String[] split = sc.next().split("");

            Stack<String> stack = new Stack<>();

            for (String s : split) {
                if ("(".equals(s)){
                    stack.push("(");
                }else{
                    if(stack.size() != 0){
                        stack.pop();
                    }else{
                        results[i] = "NO";
                        break;
                    }
                }
            }

            if(!"NO".equals(results[i])){
                if(stack.size() != 0){
                    results[i] = "NO";
                }else{
                    results[i] = "YES";
                }
            }
        }

        for (String result : results) {
            System.out.println(result);
        }

    }
}
