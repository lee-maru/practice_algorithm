//https://www.acmicpc.net/problem/11047

/**
 * 문제
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 *
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 *
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 *
 * 출력
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 10 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 */

import java.util.Scanner;
import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 화폐 종류 갯수
        int V = sc.nextInt(); // 금액
        int result = 0;
        int[] arr = new int[N];

        // 화폐 단위 입력 받기
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // 화폐 정렬
        Arrays.sort(arr);
        
        // 금액이 0이 될 때 까지 진행
        for(int i=arr.length-1; i>0; i--){
            if(V > arr[i]){ // 현재 가지고 있는 금액보다 클 경우 ex) 금액 : 5000 잔돈 : 4000 일경우 ok, 금액 5000, 잔돈 6000원 일 경우 false
                result = result + V/arr[i];
                V = V%arr[i];
            }
        }
        System.out.println(result);
    }

}
