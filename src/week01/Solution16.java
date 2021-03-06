package week01; /**
 * 뒤집기
 *
 * 문제
 * 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
 * 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 *
 * 예를 들어 S=0001100 일 때,
 *
 * 전체를 뒤집으면 1110011이 된다.
 * 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
 * 하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
 *
 * 문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
 *
 * 입력
 * 첫째 줄에 문자열 S가 주어진다. S의 길이는 100만보다 작다.
 *
 * 출력
 * 첫째 줄에 다솜이가 해야하는 행동의 최소 횟수를 출력한다.
 *
 * 예제 입력 1
 * 0001100
 * 예제 출력 1
 * 1
 */
import java.util.Scanner;
public class Solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coins = sc.nextLine();
        String[] oneCoin = coins.split("0");
        String[] zeroCoin = coins.split("1");
        int oneCoinCnt = 0;
        int zeroCoinCnt = 0;

        for (String value : zeroCoin) {
            if (!"".equals(value)) {
                zeroCoinCnt++;
            }
        }

        for (String s : oneCoin) {
            if (!"".equals(s)) {
                oneCoinCnt++;
            }
        }

        if(oneCoinCnt > zeroCoinCnt){
            System.out.println(zeroCoinCnt);
        }else if(zeroCoinCnt > oneCoinCnt){
            System.out.println(oneCoinCnt);
        }else{
            System.out.println(oneCoinCnt);
        }
    }
}
