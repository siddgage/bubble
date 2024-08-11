package com.themedia.bubblelib.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;

    public static LocalDate getLocalDate(String date) {
        return LocalDate.parse(date, df);
    }
}
