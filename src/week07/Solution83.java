package week07;

public class Solution83 {
    public static void main(String[] args) {
        Solution82.StaticNestedClass snc1 = new Solution82.StaticNestedClass(1,2);
        Solution82.StaticNestedClass snc2 = new Solution82.StaticNestedClass(1,2);

        if(snc1 == snc2)
            System.out.println("sn1 , snc2 - 같음 reference");
        else
            System.out.println("sn1 , snc2 - 다름 reference");

        Solution82.NestedClass nc1 = new Solution82().new NestedClass(1,2);
        Solution82.NestedClass nc2 = new Solution82().new NestedClass(1,2);

        if(nc1 == nc2)
            System.out.println("nc1 , nc2 - 같음 reference");
        else
            System.out.println("nc1 , nc2 - 다름 reference");

    }
}
