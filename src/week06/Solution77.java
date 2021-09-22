package week06;
// https://www.acmicpc.net/problem/1946

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution77 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine()) + 1;
            int[] list = new int[N];
            for (int j = 0; j < N-1; j++) {

                String s = br.readLine();
                String[] s1 = s.split(" ");
                list[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
            }
            int cnt = 1;
            int start = list[1];
            for (int j = 1; j < list.length; j++) {
                if(start > list[j]){
                    start = list[j];
                    cnt++;
                }

            }
            result[i] = cnt;
        }

        for (int j : result) {
            System.out.println(j);
        }
    }
}
