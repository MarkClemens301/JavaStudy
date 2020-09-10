package Java语法._9常用类;/* 2020/8/28 0:23 */

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
/*
第一代 jdk1.0 java.util.Date
第二代 jdk1.1 java.util.Calendar
第三代 jdk1.8 java.time
 */
public class 时间API {
    @Test
    public void new_API_time() {
        //import java.time.*;
        LocalDate ld = LocalDate.now();
        System.out.println("ld = " + ld);
        LocalDate of = LocalDate.of(2017, 8, 13);
        System.out.println(of);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        System.out.println("now.getDayOfWeek() = " + now.getDayOfWeek());
        System.out.println("now.getMonth() = " + now.getMonth());
        System.out.println("now.getDayOfYear() = " + now.getDayOfYear());
    }

    @Test
    public void canlendarT() {
        Calendar cl = Calendar.getInstance();
        int days;
        days = cl.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        days = cl.get(Calendar.DAY_OF_YEAR);
        System.out.println(days + ", " + days * 1.0 / 365);

        double timePercent = 1.0 / 365 * Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        System.out.println("timePercent = " + timePercent);

        int dayofweek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println("dayofweek = " + dayofweek);
    }

}
