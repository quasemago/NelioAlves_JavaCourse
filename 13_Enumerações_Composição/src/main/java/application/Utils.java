package application;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static final DateTimeFormatter BIRTH_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter ORDER_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
            .withZone(ZoneId.systemDefault());
}
