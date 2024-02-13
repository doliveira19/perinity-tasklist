package com.perinity.tasklist.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static LocalDate converterStringToLocalDate(String data) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fdata = LocalDate.parse(data, formato);
        return fdata;
    }
}
