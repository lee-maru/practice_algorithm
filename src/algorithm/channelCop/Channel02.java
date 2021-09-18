package algorithm.channelCop;

import java.util.*;

public class Channel02 {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        Channel02 c = new Channel02();
        String solution = c.solution(2, 2, 5);
        System.out.println();
        System.out.println(solution);
    }

    public String solution(int n, int m, int k) {
        solution2(n,m,"");
        Collections.sort(list);

        return list.get(k-1);
    }

    public void solution2(int n, int m, String str){
        if(n == 0 && m == 0)
            list.add(str);
        if(m > 0){
            solution2(n,m-1,str+")");
        }
        if(n > 0){
            solution2(n-1, m, str+"(");
        }
    }
}
