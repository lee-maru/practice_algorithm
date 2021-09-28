package week07;

import java.util.*;

//https://www.acmicpc.net/problem/2941
public class Solution80 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        String[] regx = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (String s : regx)
            str = str.replace(s, "a");

        System.out.println(str.split("").length);
    }
}
