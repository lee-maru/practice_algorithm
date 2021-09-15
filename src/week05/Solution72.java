package week05;

import java.util.*;

public class Solution72 {
    public static void main(String[] args) throws InterruptedException {

        Solution72 s = new Solution72();
        /*int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int weight = 100;
        int bridge_length = 100;

        int time = s.solution(bridge_length, weight, truck_weights);
        System.out.println(time);*/
        int[] D = {2,5,9,2,1,4};
        int X = 4;
        /*System.out.println(s.task3(D, X));*/

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) throws InterruptedException {
        Queue<Integer> q = new LinkedList<>();

        int bridgeLength = 1;
        int bridgeWeight = truck_weights[0];
        int time = 2;
        int index = 1;
        int cnt = 2;
        q.offer(truck_weights[0]);

        while (!q.isEmpty()) {
            Thread.sleep(10);
            time++;
            System.out.println("time : " + time);
            if (cnt == bridge_length) {
                int truck = q.poll();
                if(q.size() == 0){
                    cnt = 0;
                }else{
                    cnt = bridge_length-1;
                }
                bridgeWeight = bridgeWeight - truck;
                bridgeLength = bridgeLength - 1;
            }
            if (bridge_length >= bridgeLength + 1
            && index < truck_weights.length && weight >= bridgeWeight + truck_weights[index]) {
                q.offer(truck_weights[index]);
                bridgeWeight = bridgeWeight + truck_weights[index];
                bridgeLength++;
                index++;
            }
            cnt++;
        }

        return time;
    }

/*    public int task3(int[] D, int X){
        int cnt = 1;
        int beforeLevel = D[0];
        // 조건 1
        for (int i = 1; i < D.length; i++) {
            System.out.println(D[i]);
            if(Math.abs(D[i] - beforeLevel) > X){
                System.out.println(D[i] + " > " + beforeLevel);
                beforeLevel = D[i];
                cnt++;
            }

        }
        return cnt;
    }*/
}
