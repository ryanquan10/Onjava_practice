package J8time;

import org.junit.Test;
import sun.util.resources.LocaleData;

import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.stream.Stream;

public class TestLocalDatetime {
    /**
     * LocalDate LocalDateTime LocalTime
     */
   @Test
    public void test1(){
       LocalDateTime dt = LocalDateTime.now();
       System.out.println(dt);
       LocalDate d = LocalDate.now();
       System.out.println(d);
       LocalTime lt = LocalTime.now();
       System.out.println(lt);

       LocalDateTime ldt2 = LocalDateTime.of(2015,10,19,13,22,33);

       LocalDateTime ldt3 = ldt2.plusYears(2);
       System.out.println(ldt3);

       LocalDateTime ldt4 = ldt3.minusMonths(2);
       System.out.println(ldt4);

       System.out.println(ldt4.getMonth());
       System.out.println(ldt4.getMonthValue());



   }
   @Test
    public void test2(){
       Instant ins1 = Instant.now();
       System.out.println(ins1);

       OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
       System.out.println(odt);

       System.out.println(ins1.toEpochMilli());

       Instant ins2 = Instant.ofEpochSecond(1000);
       System.out.println(ins2);




   }
   @Test
    public void test3(){
       Instant ins = Instant.now();

       Instant ins2 = Instant.now();
       Duration duration = Duration.between(ins,ins2);
       System.out.println(duration);
   }

   @Test
    public void test4(){
       LocalDate d1 = LocalDate.of(2015,1,1);
       LocalDate d2 = LocalDate.now();
       Period period;
       System.out.println(period = Period.between(d1,d2));
       System.out.println(period.getYears());
       System.out.println(period.getMonths());
       System.out.println(period.getDays());

   }
   @Test
    public void test5(){
       LocalDateTime d1 = LocalDateTime.now();
       System.out.println(d1);

       LocalDateTime d2 =d1.withDayOfMonth(10);
       System.out.println(d2);

       d2.with(TemporalAdjusters.firstDayOfMonth());
       d2.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
   }


}
