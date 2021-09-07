package week04;

// https://www.acmicpc.net/problem/1003
import java.util.*;
public class Solution59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 갯수
        int[] tc = new int[T]; // 테스트케이스 갯수만큼 TestCase 초기화 변수이름 'T'est'C'ase
        int max = 0; // tc의 max 값을 알도록 한다. dp를 cache 라는 이름의 배열로 진행

        for (int i = 0; i < tc.length; i++) { // TC 를 초기화 하면서 max 값을 알도록 진행
            int temp = sc.nextInt();
            if(i == 0){
                max = temp;
            }else{
                if(max < temp){
                    max = temp;
                }
            }
            tc[i] = temp;
        }

        int[][] cache = new int[max+1][2]; // cache 를 정의 함 배열의 [TC 숫자] [0~1] 0의 갯수 1의 갯수가 몇개인지

        // 0 일 때 초기화
        cache[0][0] = 1;
        cache[0][1] = 0;

        // 1 일 때 초기화
        cache[1][0] = 0;
        cache[1][1] = 1;

        // 2 일 때 초기화
        cache[2][0] = 1;
        cache[2][1] = 1;

        for (int j = 3; j < max+1; j++) {
            cache[j][0] = cache[j-1][0] + cache[j-2][0];
            cache[j][1] = cache[j-1][1] + cache[j-2][1];
        }

        for (int k : tc) {
            System.out.println(cache[k][0] + " " + cache[k][1]);
        }
    }
}
