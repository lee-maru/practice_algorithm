/**
 * 문제
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?
 *
 * 입력
 * 첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
 *
 * 출력
 * 첫째 줄에 자연수 N의 최댓값을 출력한다.
 *
 * 예제 입력 1
 * 200
 * 예제 출력 1
 * 19
 */
import java.util.Scanner;

public class Solution10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong(); // S 입력
        long N = 1; // 자연수 갯수
        long sum = 0;
        while(sum <= S){
            N++;
            if((N & 1) == 0){ // 짝수인지 구분
                sum = (1+N) * (N/2);
            }else{
                sum = ((1+N)*(N/2)) + ((1+N)/2);
            }
        }
        System.out.println(N-1);
    }
}
