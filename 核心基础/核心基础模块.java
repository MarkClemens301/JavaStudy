import java.time.LocalDateTime;
import java.util.Date;

public class 核心基础模块 {
    public static void main(String[] args) {
        System.out.println("核心基础模块");

        /*时间模块*/
        //V1.0
        long timeDate = new Date().getTime();
        System.out.println(String.format("timeDate: %s, time: %s" , timeDate, new Date(timeDate)));

        //V3.0 jdk8
        int year = LocalDateTime.now().getYear();//直接使用静态方法
        System.out.printf("year = %d%n", year);

        long timeStamp = System.currentTimeMillis();
        Date date = new Date(timeStamp);
        System.out.println("date = " + date);
    }
}
