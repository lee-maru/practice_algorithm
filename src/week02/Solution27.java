package week02;

/**
 * 문제 : https://www.acmicpc.net/problem/1697
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 *
 * 출력
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 *
 * 예제 입력 1
 * 5 17
 * 예제 출력 1
    * 4
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Solution27 {
    static int MAX = 100_001; // K(0 ≤ K ≤ 100,000) N(0 ≤ N ≤ 100,000)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이의 현 위치
        int K = sc.nextInt(); // 동생 현휘치
        boolean[] visited = new boolean[MAX];
        int[] timeArr = new int[MAX];

        Queue<Integer> q = new LinkedList<>(); // q생성
        q.offer(N); // 수빈이의 현위치
        visited[N] = true; // 수빈이의 방문 위치

        while(!q.isEmpty()){
            Integer now = q.poll();
            if(now == K) break; // 현재 동생의 위치를 방문했다면 종료
            if(now * 2 < MAX && !visited[now*2]){
                q.offer(now*2); // q에 적재
                visited[now*2] = true; // 방문
                timeArr[now*2] = timeArr[now] + 1; // 1초 시간 증가
            }

            if(now+1 < MAX && !visited[now+1]){
                q.offer(now+1); // q에 적재
                visited[now+1] = true; // 방문
                timeArr[now+1] = timeArr[now] + 1; // 1초 시간 증가
            }

            if(now-1 >= 0 && !visited[now-1]){
                q.offer(now-1); // q에 적재
                visited[now-1] = true; // 방문
                timeArr[now-1] = timeArr[now] + 1; // 1초 시간 증가
            }
        }
        System.out.println(timeArr[K]);
    }
}
