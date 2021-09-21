package week06;

// https://www.acmicpc.net/problem/1946
import java.util.*;

public class Solution77 {
    public static class Apply implements Comparable<Apply>{
        int resumeScore;
        int interviewScore;

        public Apply(int resumeScore, int interviewScore){
            this.resumeScore = resumeScore;
            this.interviewScore = interviewScore;
        }

        @Override // 1차 점수를 통해 지원자 분들의 정렬을 진행
        public int compareTo(Apply otherApplicant){
            if(this.resumeScore >= otherApplicant.resumeScore){
                return 1; // 서류 점수로 오름차순 진행
            }else{
                return -1; // 점수가 낮거나 같으면 기본으로 정렬
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int cnt = 1;
            List<Apply> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(new Apply(sc.nextInt(), sc.nextInt()));
            }

            Collections.sort(list);

            for (int j = 0; j < list.size(); j++) {
                if(j == list.size()-1){
                    break;
                }
                if(list.get(j).interviewScore > list.get(j+1).interviewScore){
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
