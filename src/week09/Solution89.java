package week09;

import java.util.Scanner;
import java.util.Stack;

public class Solution89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();

        int result = 0;

        String[] split = next.split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if(s.equals(")")){
                stack.pop();
                if(split[i-1].equals(")"))
                    result += 1;
                else
                    result = result+stack.size();
            }else{
                stack.push(s);
            }

        }

        System.out.println(result);
    }
}
