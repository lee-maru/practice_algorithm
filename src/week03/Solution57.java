package week03;

// https://www.acmicpc.net/problem/9466
import java.util.*;
public class Solution57 {
    static List<List<Integer>> matrix = new ArrayList<>();
    static int[][] map;
    static int startPoint = 0;
    static int endPoint = 0;
    static boolean[] visited;
    static int[] dp;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for (int i=0; i<T; i++){

            N = sc.nextInt()+1;
            map = new int[N][1];
            dp = new int[N];
            visited = new boolean[N];

            endPoint = 0;

            for (int j = 1; j < N; j++){
                map[j][0] = sc.nextInt();
            }

            int cnt = 0;
            for (int j = 1; j < N; j++) {
                visited = new boolean[N];
                startPoint = j;
                if(map[startPoint][0] != startPoint){
                    if(dp[map[j][0]] == 0){
                        dfs(startPoint);
                    }else{
                        endPoint = dp[map[j][0]];
                    }
                    if(j != endPoint){
                        dp[startPoint] = endPoint;
                        cnt++;
                    }
                }
            }
            result[i] = cnt;
        }
        for(int t : result){
            System.out.println(t);
        }
    }

    public static int dfs(int node){

        int otherNode = map[node][0];
        if(!visited[otherNode]){

            if(otherNode == startPoint){
                dp[startPoint] = node;
                endPoint = otherNode;
                return otherNode;
            }

            visited[otherNode] = true;

            if(dp[otherNode]!=0){
                dp[node] = map[otherNode][0];
                endPoint = dp[otherNode];
            }else{
                endPoint = otherNode;
                int x = dfs(otherNode);
                dp[node] = x;
            }
        }
        return endPoint;
    }
}
