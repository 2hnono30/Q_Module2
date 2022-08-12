package util;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatUtil {
    private static final String CURRENCY_FORMAT = "$#,##0.00";
    private static final String DATE_FORMAT = "HH:mm:ss - dd/MM/yyyy";

    public static String currencyFormatUtil(double productPrice) {
        DecimalFormat decimalFormat = new DecimalFormat(CURRENCY_FORMAT);
        return decimalFormat.format(productPrice);
    }

    public static String dateFormatUtil(Instant instant) {
        return dateFormatUtil(instant, null);
    }

    public static String dateFormatUtil(Instant instant, String dateFormat) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat != null ? dateFormat : DATE_FORMAT).withZone(ZoneId.systemDefault());
        return dateTimeFormatter.format(instant);
    }

}
