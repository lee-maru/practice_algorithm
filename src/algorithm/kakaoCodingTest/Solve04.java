package algorithm.kakaoCodingTest;

import java.util.*;

public class Solve04 {
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] solution = Solve04.solution(9, info);
        for (int i = 0; i < info.length; i++) {
            System.out.print(info[i] + " ");
        }
        System.out.println();
        for(int i : solution){
            System.out.print(i + " ");
        }
    }
    public static int[] reverseList(int[] list){
        int[] tempList = new int[list.length];

        for (int i = list.length - 1, j = 0; i >= 0; i--, j++) {
            tempList[j] = list[i];
        }
        return tempList;
    }

    public static int[] solution(int n, int[] info) {
        int[][] lionScores = new int[info.length][info.length];
        info = reverseList(info);

        for (int i = 10; i >= 0; i--) {
            int cnt = 0;
            for (int j = i; j >= 0; j--) {
                if (info[j] + 1 <= n && cnt + info[j] + 1 <= n) {
                    lionScores[i][j] = info[j] + 1;
                    cnt = cnt + info[j] + 1;
                }
                if (cnt >= 5){
                    break;
                }
            }
            if(cnt <= 5){
                for (int j = 10; j >= 0; j--) {
                    if (info[j] + 1 <= n && cnt + info[j] + 1 <= n) {
                        lionScores[i][j] = info[j] + 1;
                        cnt = cnt + info[j] + 1;
                    }
                    if (cnt >= 5){
                        break;
                    }
                }
            }
        }

        System.out.println();
        System.out.println();
        int[] tempList = new int[lionScores.length];
        for (int i = 10; i >= 0; i--) {
            int aScore = 0;
            int lScore = 0;
            for (int j = 10; j >= 0 ; j--) {
                if(info[j] >= lionScores[i][j]){
                    if(info[j] != 0)
                        aScore = aScore + j;
                }else{
                    lScore = lScore + j;
                }
            }
            if(lScore > aScore){
                tempList[i] = lScore;
            }
        }
        int maxIndex = 0;
        int max = tempList[0];

        for (int i = 1; i < tempList.length; i++) {
            if(max < tempList[i]){
                maxIndex = i;
                max = tempList[i];
            }
        }
        if(max == 0){
            return new int[]{-1};
        }
        return reverseList(lionScores[maxIndex]);
    }
}
