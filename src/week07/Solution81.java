package week07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/board/view/25456
 */
public class Solution81 {
    static String[] results;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        results = new String[T];
        for (int i = 0; i < T; i++) {
            int finalI = i;
            String order = sc.next();
            int length = sc.nextInt();
            String str = sc.next();
            Thread thread = new Thread(() -> solve(str, order, length, finalI));
            thread.start();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
    public static void solve(String str, String order, int length, int index){
        List<String> split = new ArrayList<>(Arrays.asList(str.split("\\D")));

        if(length != 0){
            split.remove(0);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            if('R' == order.charAt(i)){
                sb.append('R');
            }else if('D' == order.charAt(i)) {
                sb.append('D');
            }

            if((i+1 < order.length() && order.charAt(i) != order.charAt(i+1)) || i == order.length()-1 ){

                if('R' == sb.toString().charAt(0)){
                    if(sb.toString().length()%2 == 1){
                        split.sort(Comparator.reverseOrder());
                    }
                }

                if('D' == sb.toString().charAt(0)){
                    if(sb.toString().length() < split.size()){
                        split = split.subList(sb.toString().length(), split.size());
                    }else{
                        results[index] = "ERROR";
                        return;
                    }
                }

                sb = new StringBuilder();
            }

        }
        results[index] = split.stream().collect(Collectors.joining(",", "[", "]"));
    }
}
