package algorithm.collection;

public class RegxTest {
    public static void main(String[] args) {
        String str = "/backoffice/user/investorList";
        String str2 = "/backoffice/app/v1/faq/getFrequentList";
        System.out.println(str.matches("app/v1"));
        System.out.println(str2.matches("(.*)app/v1(.*)"));
    }
}
