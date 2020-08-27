package _9常用类;/* 2020/8/28 0:23 */

import org.junit.Test;

import java.util.*; //import java.io.*;

public class 时间API {
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
    }
}
