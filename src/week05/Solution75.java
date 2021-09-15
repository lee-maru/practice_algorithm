package week05;

import java.util.*;
public class Solution75 {
    public static void main(String[] args) {
        String[] list = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";

        Solution75 s = new Solution75();
        System.out.println(s.solution(begin, target, list));

    }

    static class Node{
        String start;
        int cnt;
        Node(String start,int cnt){
            this.start = start;
            this.cnt = cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        int[] results = new int[words.length];
        q.offer(new Node(begin, 0));


        while(!q.isEmpty()){
            Node start = q.poll();
            if(start.start.equals(target))
                return start.cnt;

            for (int i = 0; i < words.length; i++) {

                if(!visited[i] && results[i] == 0){

                    String[] startSplit = start.start.split("");
                    String[] wordSplit = words[i].split("");

                    int diffChar = 0;
                    for (int j = 0; j < wordSplit.length; j++) {
                        if(!startSplit[j].equals(wordSplit[j]))
                            diffChar++;
                    }

                    if(diffChar == 1){
                        visited[i] = true;
                        q.offer(new Node(words[i],start.cnt+1));
                        results[i] = start.cnt+1;
                    }
                }
            }
        }

        return 0;
    }
}
