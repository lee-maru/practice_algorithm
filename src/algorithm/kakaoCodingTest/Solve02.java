package algorithm.kakaoCodingTest;

public class Solve02 {
    public static void main(String[] args) {
        for (int i = 1; i < 1000000; i++) {
            for (int j = 3; j < 11; j++) {
                System.out.println("i " + i);
                System.out.println("j " + i);
                int result = Solve02.solve(i,j);
                System.out.println(result);
            }
        }
    }
    public static boolean isPrime(Long num){
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static int solve(int n, int k){
        int result = 0;
        StringBuilder str = new StringBuilder();
        while(n != 0){
            if( (n % k) < 10 ) {
                str.insert(0, (n % k));
                n /= k;
            }
            else {
                int temp1 = (char)((n % k)  + 55);
                str.insert(0, temp1);
            }
        }
        String s[] = new String(str).split("0");
        for (int i = 0; i < s.length; i++) {
            if(!"".equals(s[i]) && Long.parseLong(s[i]) > 1
            && Solve02.isPrime(Long.parseLong(s[i]))){
                result++;
            }
        }
        return result;
    }
}
