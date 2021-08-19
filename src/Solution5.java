/**
 * 문제 & 설명 : https://www.acmicpc.net/problem/1541
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 *
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 *
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 정답을 출력한다.
 *
 * 예제 입력 1
 * 55-50+40
 * 예제 출력 1
 * -35
 * 출처
 * 문제를 번역한 사람: baekjoon
 * 잘못된 조건을 찾은 사람: windflower
 * 알고리즘 분류
 * 수학
 * 문자열
 * 그리디 알고리즘
 * 파싱
 */
// 55-1+2+34+5+67+8-13 = n
// 55-(1+2+34+5+67+8)-13 = n


import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mathProblem = sc.next(); // 산식
        String opPlus = "[\\+]"; // 정규식 +
        String opSub = "[-]"; // 정규식 -
        int result = 0; // 결과 값
        String[] literals = mathProblem.split(opSub); // - 를 분기점으로 처리 정규식 처리
        /**
         * 1+23-421+32-35
         * n [n]
         * 1 1+23
         * 2 421+32
         * 3 35
         * 1+23-(421+32)-35
         */
        List<Integer> sums = new ArrayList<>();

        // O(n^2)
        for(int i = 0; i < literals.length; i++){
            String[] pluses = literals[i].split(opPlus);
            int temp = 0;
            for(int j = 0; j < pluses.length; j++){
                temp = temp  + Integer.parseInt(pluses[j]);
            }
            sums.add(temp);
        }

        for(int i = 0; i < sums.size(); i++){
            if(i == 0){
                result = result + sums.get(i);
            }else{
                result =  result - sums.get(i);
            }
        }
        System.out.println(result);
    }
}
