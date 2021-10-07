package algorithm.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxTest {
    public static void main(String[] args) {
        String str4 = "http://localhost:8480/backoffice/";
        String str5 = "https://localhost:8480/backoffice/inquiry/inquiryList";
        String matxh = "(https?:\\/\\/)?(www\\.)?(localhost:8480)(\\/backoffice)\\/*([a-zA-Z\\/]*)";
        Pattern pattern = Pattern.compile(matxh);
        Matcher m = pattern.matcher(str4);
        String rr = "(https?:\\/\\/)?(www\\.)?(localhost:8480)(\\/backoffice)\\/*([a-zA-Z\\/]*)";
        System.out.println(matxh);
        System.out.println(Pattern.matches(rr,str5));
        System.out.println(m.find());
        System.out.println("5: " + m.group(5));
    }
}
