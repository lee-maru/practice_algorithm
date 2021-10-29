package studyJava.serial;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

class SerialStudyTest {

    public static void main(String[] args) throws IOException{
        int days = 44410;
        LocalDate start = LocalDate.of(1900,1,1);
        LocalDate dats = start.plusDays(days).minusDays(2);
        System.out.println(dats);
    }
    public Date convert(String dateStr, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    private final String[] formats = {
            "yyyy-MM-dd'T'HH:mm:ss.SSS",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            "yyyy-MM-dd'T'HH:mm:ssXXX",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd",
            "yyyyMMddZ",
            "yyyyMMdd",
    };

    public Date convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        for (String format : formats) {
            Date convertDate = convert(s, format);
            if (convertDate != null) {
                return convertDate;
            }
            convertDate = convert(s.replaceAll(".", ""), format);
            if (convertDate != null) {
                return convertDate;
            }
        }
        return null;
    }

}