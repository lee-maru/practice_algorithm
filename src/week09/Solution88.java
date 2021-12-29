package week09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

// https://www.acmicpc.net/problem/1935
/*
5
ABC*+DE/-
(A+(B*C))-(D/E)
1 A
2 B
3 C
4 D
5 E
7 - 0.8
 */
public class Solution88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        Queue<Integer> numQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            numQueue.offer(sc.nextInt());
        }

        String[] split = str.split("");

        Stack<String> stack = new Stack<>();
        Stack<String> operator = new Stack<>();

        for (String s : split) {
            if(Pattern.matches("^[a-zA-Z]*$", s)){
                stack.push(String.valueOf(numQueue.poll()));
            }else{
                stack.push(s);
            }
        }

        while (!stack.isEmpty()){
            String pop = stack.pop();
            if(!Pattern.matches("^[0-9]*$", pop)){
                operator.push(pop);
            }else{
                String pop2;
                if(!stack.isEmpty()){
                     pop2 = stack.pop();
                }else{
                    
                }
                Double.parseDouble(pop);
                Double.parseDouble(pop2);
                oper()
            }
        }
    }
    private double oper (double num, double num2, String oper){
        double result = switch (oper) {
            case "+" -> num + num2;
            case "-" -> num - num2;
            case "/" -> num / num2;
            case "*" -> num * num2;
            default -> 0;
        };
        return result;
    }
}
