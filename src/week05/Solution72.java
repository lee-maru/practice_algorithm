package week05;

import java.util.*;

public class Solution72 {
    public static void main(String[] args) throws InterruptedException {

        Solution72 s = new Solution72();
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int weight = 100;
        int bridge_length = 100;

        int time = s.solution(bridge_length, weight, truck_weights);
        System.out.println(time);
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
                System.out.println("truck 나옴 " + truck);
                bridgeWeight = bridgeWeight - truck;
                bridgeLength = bridgeLength - 1;
            }
            if (bridge_length >= bridgeLength + 1
            && index < truck_weights.length && weight >= bridgeWeight + truck_weights[index]) {
                q.offer(truck_weights[index]);
                System.out.println("truck 들어감 " + truck_weights[index]);
                bridgeWeight = bridgeWeight + truck_weights[index];
                bridgeLength++;
                index++;
            }
            cnt++;
        }

        return time;
    }
}
