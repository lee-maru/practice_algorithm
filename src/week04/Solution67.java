package week04;
//https://www.acmicpc.net/problem/2748
import java.util.*;
public class Solution67 {
    public static void main(String[] a) {
        long[] s = new long[92];
        s[1]=1;
        for (int i = 2; i < s.length; i++) {
            s[i]=s[i-1]+s[i-2];
        }
        System.out.print(s[new Scanner(System.in).nextInt()]);
    }
}
