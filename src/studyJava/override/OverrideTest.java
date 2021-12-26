package studyJava.override;

public class OverrideTest {
    int x;
    public void foo(Integer i){
        System.out.println(i);
    }

    public void foo(String str){
        System.out.println(str);
    }

    public void foo(int x){
        System.out.println(x);
    }

    public static void main(String[] args) {
        OverrideTest ov = new OverrideTest();
        ov.foo(1);
        ov.foo(new Integer(1));
        ov.foo("1");
    }
}
