package week04;

//https://www.acmicpc.net/problem/11726
import java.util.*;
public class Solution61 {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        long[] c = new long[1002];
        c[1] = 1;
        c[2] = 2;
        for (int i=3; i<1002; i++) {
            c[i]=(c[i-1]+c[i-2]) %10007;
        }
        System.out.print(c[s.nextInt()]);
    }
}