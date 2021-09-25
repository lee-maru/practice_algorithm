package algorithm;
//-XX:+PrintGCDetails

public class Study {
    public static void main(String[] args) {
        long start;
        long end;

        String str = "";
        start = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            str = str + i;
        }
        end = System.nanoTime();
        System.out.println("String 50000 연산 시간(nano) --> (" + (end-start) + ")" );

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            sb.append(i);
        }
        end = System.nanoTime();

        System.out.println("StringBuilder 50000 연산 시간(nano) --> (" + (end-start) + ")" );

    }
}
