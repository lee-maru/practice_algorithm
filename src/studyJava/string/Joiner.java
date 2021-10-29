package studyJava.string;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Joiner {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println(map.toString());

        StringJoiner stringJoiner = new StringJoiner(",");
        for (String s : map.keySet()) {
            stringJoiner.add(s);
        }

        System.out.println(stringJoiner);

    }
}
