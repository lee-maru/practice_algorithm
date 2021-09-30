package week07;

public class Solution82 {

    public void outerClassFoo(){
        System.out.println("outerClassFoo 호출 완료");
    }


    public class NestedClass{
        private int x;
        private int y;
        public NestedClass(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void innerClassFoo(){
            System.out.println("outerClassFoo 호출 진행");
            outerClassFoo();
        }
    }

    static public class StaticNestedClass{
        private int x;
        private int y;
        public StaticNestedClass(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void innerClassFoo(){
            System.out.println("outerClassFoo");
        }
    }

    public static void main(String[] args) {
        String str = "[]";
        String[] st = str.split("\\D");
    }
}
