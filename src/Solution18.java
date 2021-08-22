/**
 * 문제
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 *
 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다.
 * 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 *
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
 *
 * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
 *
 * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
 *
 * 모든 숫자는 양의 정수이다.
 *
 * 출력
 * 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
 *
 * 예제 입력 1
 * 보석 N, 가방 K
 * 2 1
 * (보석1)무게 Mi, (보석1)가격 Vi
 * 5 10
 * (보석2)무게 Mi, (보석2)가격 Vi
 * 100 100
 * 가방무게 Ki
 * 11
 * 예제 출력 1
 * 10
 *
 *
 * 예제 입력 2
 * 보석 N, 가방 K
 * 3 2
 * (보석1)무게 Mi, (보석1)가격 Vi
 * 1 65
 * (보석2)무게 Mi, (보석2)가격 Vi
 * 5 23
 * (보석3)무게 Mi, (보석3)가격 Vi
 * 2 99
 * 가방무게 Ki
 * 10
 * 가방무게 Ki
 * 2
 * 예제 출력 2
 * 164
 */
import java.util.*;

public class Solution18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 보석 갯수
        int K = sc.nextInt(); // 가방 갯수
        Jewel[] jewels = new Jewel[N];
        PriorityQueue<Integer> bags = new PriorityQueue<>(); // 가방 리스트 생성
        int result = 0; // 총 훔친 보석의 가격

        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt(); // 보석의 무게
            int price = sc.nextInt(); // 보석의 가격
            jewels[i] = new Jewel(weight,price);
        }
        Arrays.sort(jewels);

        for(int i=0; i<K; i++){
            bags.offer(sc.nextInt()); // 가방의 무게를 입력
        }

        while(!bags.isEmpty()){
            int bagWeight = bags.poll();
            for (int j = 0; j < jewels.length; j++) {
                Jewel expectedStealJewel = jewels[j];
                // 가방의 사이즈보다 훔칠 보석의 사이즈가 같거나 적은 상황 And 훔치려고 하는 보석의 상태가 훔쳐져있찌 않은 상황일 때
                if(bagWeight >= expectedStealJewel.weight && !expectedStealJewel.stealStatus){
                    result = result+expectedStealJewel.price; // 결과 값에 자신이 훔친
                    jewels[j].stealStatus = true; // 리스트에서 제거
                    break; // 이미 가방에 훔쳤다면, 다른 물건을 훔칠 수 없으므로 종료
                }
            }
        }

        System.out.println(result);
    }
    static public class Jewel implements Comparable<Jewel>{
        int weight; // 무게
        int price; // 가격
        boolean stealStatus = false;
        public Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel otherJewel){
            if(this.price < otherJewel.price){ // 비싼것부터 내림차순
                return 1;
            }else{
                return -1;
            }
        }
    }
}
