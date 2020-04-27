package PracticeFromAnki;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.OffsetDateTime.now;

public class TestTimeAPI {
   @Test
    public void test1(){
       Instant ins1 = Instant.now();
       System.out.println(ins1);

       OffsetDateTime ztime = ins1.atOffset(ZoneOffset.ofHours(8));

       ins1.toEpochMilli();

       Instant ins2 = Instant.ofEpochSecond(1);
       System.out.println(ins2);
   }
   @Test
    public  void test2(){
       DateTimeFormatter formatter =DateTimeFormatter.ISO_DATE_TIME;
       LocalDate date =LocalDate.now();
       String timeStr =formatter.format(date);
       System.out.println(timeStr);

       DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
       LocalDateTime ldt =LocalDateTime.now();
       String strDate = ldt.format(dtf);
       System.out.println(strDate);
   }
    @Test
    public  void test3(){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy年MM月dd日");
       LocalDateTime date = LocalDateTime.now();
       String str = formatter.format(date);
        System.out.println(str);
    }
    @Test
    public void test4(){
        LocalDateTime  dateTime =LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
       ZonedDateTime zdt = dateTime.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt);
    }
    @Test
    public void test5(){
       LocalDateTime ldt = LocalDateTime.now();//
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(ldt3);

       //查找下一个休息天
        LocalDateTime ldt4 = ldt.with((ltd)->{
            if(ldt.getDayOfWeek()==DayOfWeek.FRIDAY){
                return ldt.plusDays(1);
            }else if (ldt.getDayOfWeek()==DayOfWeek.SUNDAY){
                return ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
            }else{
                return ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
            }
        });
    }
    @Test
    public void test6(){
        LocalDateTime ldt = LocalDateTime.now();//
        LocalDateTime workingday =ldt.with((l) -> {
            LocalDateTime ldt1 = (LocalDateTime) l;
            DayOfWeek dow = ldt1.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt1.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt1.plusDays(2);
            } else {
                return ldt1.plusDays(1);
            }
        });
    }
    @Test
    public void test7(){
       DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
       String formatDay = formatter.format(LocalDateTime.now());
        System.out.println(formatDay);
        System.out.println("-----------------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(LocalDateTime.now());

        System.out.println(strDate2);

    }

    @Test
    public void test8(){
       LocalDateTime d = LocalDateTime.now();
       LocalDateTime d2 = d.withDayOfMonth(10);
       d2.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));


    }

    @Test
    public void test9(){
        LocalDate ld1 = LocalDate.of(2015,1,1); //创建一个人类能懂时间包含年月日
        LocalDate ld2 = LocalDate.now(); //获取当前时间
        Period period =Period.between(ld1,ld2);
        System.out.println("date:"+ period); //输出一个默认格式的 两个时间差

        System.out.println(period.getYears()); //只获取年
        System.out.println(period.getMonths()); //获取月
        System.out.println(period.getDays()); //获取日


    }
    @Test
    public void test10(){

    }


}
