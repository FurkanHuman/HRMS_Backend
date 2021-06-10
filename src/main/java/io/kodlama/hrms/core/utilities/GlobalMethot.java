package io.kodlama.hrms.core.utilities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GlobalMethot {
    public static Date convertToDateUsingInstant(LocalDate date) {
        return java.util.Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}
