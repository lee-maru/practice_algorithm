/**
 * 문제
 *
 * 시험은 1차 서류심사와 2차 면접시험으로 이루어진다.
 *
 * 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
 * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
 *
 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
 *
 * 출력
 * 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
 *
 * 예제 입력 1
 * 2
 * 5
 * 3 2
 * 1 4
 * 4 1
 * 2 3
 * 5 5
 * 7
 * 3 6
 * 7 3
 * 4 2
 * 1 4
 * 5 7
 * 2 5
 * 6 1
 * 예제 출력 1
 * 4
 * 3
 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Solution9 {
    // 지원자 Class 생성
    static class Applicant implements Comparable<Applicant>{
        int firstScore; // 1차 점수
        int secondScore; // 2차 점수

        public Applicant(int firstScore, int secondScore){ // 지원자 생성자 생성
            this.firstScore = firstScore;
            this.secondScore = secondScore;
        }

        @Override // 1차 점수를 통해 지원자 분들의 정렬을 진행
        public int compareTo(Applicant otherApplicant){
            if(this.firstScore >= otherApplicant.firstScore){
                return 1; // 1차 점수로 오름차순 진행
            }else{
                return -1; // 점수가 낮거나 같으면 기본으로 정렬
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 몇차시도의 지원이 있는가
        int[] results = new int[N]; // N차 지원까지 합격인원을 저장
        for(int i=0; i<N; i++){ // N차 까지 지원자 분들의 평가가 이루어짐
            int V = sc.nextInt(); // N차에 몇분의 지원자가 있는지
            int result = 0; // N차에 몇명의 합격자를 배출하는지 확인
            List<Applicant> applicants = new ArrayList<>();

            for(int j=0; j<V; j++){
                applicants.add(new Applicant(sc.nextInt(), sc.nextInt())); // 지원자 생성자 정의 하여 list에 저장
            }
            applicants.sort((o1,o2)->o1.compareTo(o2)); //1차 서류 점수를 통해 정렬

            for(int k=0; k<V; k++){
                if(k == V-1){ // 정렬을 했는데 1차 점수가 가장 높은 인원은 2차 점수와 연관 없이 합격
                    result++;
                }else{
                    int sndScore = applicants.get(k).secondScore;
                    int otherSndScore = applicants.get(k+1).secondScore;
                    if(sndScore > otherSndScore){ // 만약 1차점수가 낮은 인원이 2차점수가 자신의 위보다 높다면 합격처리
                        result++;
                    }
                }
            }
            results[i] = result;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }
}
