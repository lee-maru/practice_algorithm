import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("hello",false);
        System.out.println(map.size());
        System.out.println(map.get("hello"));
        map.put("hello",true);
        System.out.println(map.size());
        System.out.println(map.get("hello"));

    }
}
