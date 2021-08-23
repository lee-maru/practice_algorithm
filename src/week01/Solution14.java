package week01; /**
 * 문제
 * 등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.
 * <p>
 * 캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
 * <p>
 * 강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?
 * <p>
 * 강산이는 조금 더 일반화해서 문제를 풀려고 한다.
 * <p>
 * 캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
 * <p>
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다. 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.
 * <p>
 * 출력
 * 각 테스트 케이스에 대해서, 강산이가 캠핑장을 최대 며칠동안 사용할 수 있는지 예제 출력처럼 출력한다.
 * <p>
 * 예제 입력 1
 * L P V
 * 5 8 20 -> 14
 * 5 8 17
 * 0 0 0
 * 예제 출력 1
 * Case 1: 14
 * Case 2: 11
 * <p>
 * 1 2 3 4 5 6 7 8 / 9 10 11 12 13 14 15 16 / 17 / 18 19 20 21 22 23 24 /
 * 캠핑 연속일 : P , 사용가능일 : L , 휴가 : V
 * V/P = x * L = a
 * V%P = y = b
 * a+b -> 사용가능일
 * 20/8 = 3 * 5 = 15
 * 20%8 = 0
 *
 * 1 2 3 4 5 6 7 8 / 9 10 11 12 13 14 15 16 / 17
 * 5 8 17
 * 17/8 = 2 * 5 = 10
 * 17%8 = 1
 *
 * 반례
 * 1 2 3 4 5 6 7 8 9 10 11 / 12 13 14 15 16 17
 *
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (true) {
            int[] arr = new int[3];
            for (int i = 0; i < 3; i++) {
                int check = sc.nextInt();
                arr[i] = check;
            }
            if (arr[0] == 0){ // 0 이 지속적으로 들어오게 된다면 입력을 종료 시킴
                break;
            }
            list.add(arr);
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            int[] timeTable = list.get(i);
            int L = timeTable[0];
            int P = timeTable[1];
            int V = timeTable[2];
            int sum = (V/P)*L;
            int sum2 = V%P;
            if(sum2 > L){
                sum2 = L;
            }
            result[i] = sum+sum2;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println("Case " +(i+1)+": " + result[i]);
        }
    }
}
