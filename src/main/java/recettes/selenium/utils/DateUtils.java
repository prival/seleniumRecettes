package recettes.selenium.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getActualDateAsString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        return date;
    }
}
