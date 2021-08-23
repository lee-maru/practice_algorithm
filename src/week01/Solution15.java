package week01;    /**
     * 문제
     * 길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만,
     * 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때,
     * 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면,
     * 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
     *
     * 예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만,
     * 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
     *
     * 수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
     *
     * 수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 수열의 크기 N이 주어진다. N은 10,000보다 작은 자연수이다. 둘째 줄부터 N개의 줄에, 수열의 각 수가 주어진다.
     * 수열의 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
     *
     * 출력
     * 수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.
     *
     * 예제 입력 1
     * 4
     * -1
     * 2
     * 1
     * 3
     * 예제 출력 1
     * 6
     */
    import java.util.Scanner;
    import java.util.PriorityQueue;
    import java.util.Collections;

    public class Solution15 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            PriorityQueue<Long> pluses = new PriorityQueue<>(Collections.reverseOrder()); // + 의 숫자를 담을 큐
            PriorityQueue<Long> minuses = new PriorityQueue<>(); // - 의 숫자를 담을 큐
            int zeroCnt = 0;
            for (int i = 0; i < N; i++) {
                long input = sc.nextInt();
                if(input < 0){
                    minuses.add(input);
                }else if(input > 0){
                    pluses.add(input);
                }else if(input == 0){
                    zeroCnt++;
                }
            }

            long result = 0;
            while (!pluses.isEmpty()){
                if(pluses.size() == 1){
                    result = result + pluses.poll();
                }else{
                    long x = pluses.poll();
                    long y = pluses.poll();
                    if((x+y)>(x*y)){
                        result = result+(x+y);
                    }else{
                        result = result+(x*y);
                    }
                }
            }

            while (!minuses.isEmpty()){
                if(minuses.size()==1){
                    if(zeroCnt <= 0){
                        result = result + minuses.poll();
                    }else{
                        minuses.poll();
                    }
                }else{
                    result = result + (minuses.poll() * minuses.poll());
                }
            }

            System.out.println(result);
        }
    }
