package algorithm.channelCop;

public class Channel3 {
    public static void main(String[] args) {

    }
    public int solution(int[] s1, int[] s2) {
        int answer = 0;
        int zero = 0;
        for (int i = 0; i < s1.length; i++) {
            if(s1[i] == 0)
                zero = i;
        }
        for (int i = 0; i < s1.length; i++) {
            if(s1[i] != s2[i]){
            }
        }
        return answer;
    }
}
