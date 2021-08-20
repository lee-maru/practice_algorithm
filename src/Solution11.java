
import java.util.Scanner;
public class Solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityCount = sc.nextInt();
        int[] distances = new int[cityCount-1];
        int[] cityOilFee = new int[cityCount];
        int allDistance = 0; // 도시간의 총 길이
        boolean oilFeeUnity = false; // 도시간 기름 값 단합 여부
        for (int i = 0; i < distances.length; i++) {
            int distance = sc.nextInt();
            distances[i] = distance; // 배열에 넣어 둠
            allDistance = allDistance + distance; // 도시간의 총 길이를 계산함
        }

        for (int iServiceConfig = 0; i < distances.length; i++) {
            cityOilFee[i] = sc.nextInt();
            // 도시간의 오일 가격이 동결인지 체크
            if(i != 0 || i == distances.length-1){
                if(cityOilFee[i-1] == cityOilFee[i]){
                    oilFeeUnity = true;
                }
            }
        }
        if (oilFeeUnity){ // 기름 값 단합 했을 경우 계산할 필요 없이 진행
            System.out.println(allDistance * cityOilFee[0]);
            return;
        }


    }
}
