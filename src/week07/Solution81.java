package week07;

import java.util.*;
public class Solution81 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] results = new String[T];
        for (int i = 0; i < T; i++) {
            String order = sc.next();
            int length = sc.nextInt();
            String str = sc.next();
            results[i] = solve(str, order);
        }

        for (String result : results) {
            System.out.println(result);
        }
        long end = System.nanoTime();
        System.out.println("걸린 시간 --> (" + (end-start) + ")");
    }
    //2315214723
    //2890352288
    public static String solve(String str, String order){
        StringBuilder result = new StringBuilder();
        String[] split1 = str.split("\\D");
        for (int i = 0; i < split1.length; i++) {
            String s = split1[i];
            System.out.print("'"+s+"'");
        }
        List<String> split = Arrays.asList(split1);
        System.out.println(split);
        String[] orders = order.replaceAll("RD", "R D").replaceAll("DR", "D R").split(" ");

        for (int i = 0; i < orders.length; i++) {
            if('R' == orders[i].charAt(0)){
                if(orders[i].length()%2 == 1){
                    split.sort(Comparator.reverseOrder());
                }
            }else if('D' == orders[i].charAt(0)){
                if(orders[i].length() < split.size()){
                    split = split.subList(orders[i].length(), split.size());
                }else{
                    return "ERROR";
                }
            }
        }
        System.out.println(split);
        result.append("[");
        for (int i = 0; i < split.size(); i++) {
            if(i == split.size()-1)
                result.append(split.get(i));
            else
                result.append(split.get(i)).append(",");
        }
        result.append("]");

        return result.toString();
    }
}
