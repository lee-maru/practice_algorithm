/** @link : https://www.acmicpc.net/problem/5585
 *
 * @implNote 타로는 자주 JOI잡화점에서 물건을 산다.
 * JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고, 언제나 거스름돈 개수가 가장 적게 잔돈을 준다.
 * 타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때, 받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 한줄로 이루어져있고, 타로가 지불할 돈(1 이상 1000미만의 정수) 1개가 쓰여져있다.
 *
 * 출력
 * 제출할 출력 파일은 1행으로만 되어 있다. 잔돈에 포함된 매수를 출력하시오.
 *
 *
 * @implSpec
 * 예제 입력 1
 * 380
 * 예제 출력 1
 * 4
 * 예제 입력 2
 * 1
 * 예제 출력 2
 * 15
 */
import java.util.Scanner;

public class Solution6 {
    public static void main(String[] args) {
        int[] arr = {500,100,50,10,5,1};
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int count = 0;
        // 알고리즘 복잡도 O(6)
        for (int i = 0; i < arr.length; i++) {
            if(money == 0){ // 잔돈을 다 거슬러 주면 종료
                break;
            }else if(money >= arr[i]){ // 500엔보다 클경우 100엔 보다 클 경우 등등
                count = count + (money/arr[i]); // 거스름 갯수
                money = money%arr[i]; // 잔돈
            }

        }
        System.out.println(count);
    }
}
