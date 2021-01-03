import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class TestDate {
    public static void main(String[] args) {

        long publishTimeMills=1599726707391l;
        Date date=new Date(System.currentTimeMillis());
        long currentMills=date.getTime();
        long mills=currentMills-publishTimeMills;
        long seconds= mills/1000;
        long minutes= seconds / 60;
        long hour = minutes / 60;
        long day = hour / 24;
        long month = day / 30;
        long year = month / 12;
        System.out.println(mills);
        System.out.println(minutes);
        System.out.println(hour);
        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
    }
}
