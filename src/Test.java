import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * This is test notepad
 */
public class Test{
    static class Box implements Comparable<Box>{
        String name;
        int size;

        public Box(String name, int size){
            this.name =  name;
            this.size = size;
        }

        @Override
        public int compareTo(Box otherBox){
            if(this.size > otherBox.size){ // 내림차순
                return -1;
            }else if(this.size == otherBox.size){
                return -1;
            }else{ // this size < otherBox.size
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        String str = "            ";
        System.out.println("'"+str+"'");
        String trim = str.trim();
        System.out.println("'"+trim+"'");
        System.out.println(trim.equals(""));



      /*  List<Box> boxes = new ArrayList<>();
        Box[] boxList = new Box[10];

        for (int i = 0; i < boxList.length; i++) {
            boxList[i] = new Box("",i);
        }

        for (int i = 0; i < 10; i++) {
            boxes.add(new Box("",i));
        }
        // boxList 정렬
        Arrays.sort(boxList);

        // boxes 정렬
        boxes.sort((o1,o2) -> o1.compareTo(o2));

        for(Box b : boxes){
            System.out.println(b.size);
        }

        for(Box b : boxList){
            System.out.println(b.size);
        }
*/
    }

}