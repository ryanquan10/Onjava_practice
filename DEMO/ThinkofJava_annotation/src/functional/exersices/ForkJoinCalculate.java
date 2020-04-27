package functional.exersices;



import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;

    private static final long serialVersionUID = 12346596796L;

    private static final long THRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end-start;
        if(length<=THRESHOLD){
            long sum = 0;
            for(long i= start;i<=end;i++){
                sum+=i;

            }
            return sum;
        }else{
            long middle=(end+start)/2;
           ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
           left.fork();

           ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
           right.fork();

           return left.join()+right.join();

        }
    }
}


class TestForkJoin{

  @Test
  public void test1(){
      Instant start = Instant.now();

      ForkJoinPool pool = new ForkJoinPool();
      ForkJoinTask<Long> task = new ForkJoinCalculate(0,100000000l);
      Long sum = pool.invoke(task); //放入池
      System.out.println(sum);

      Instant end = Instant.now();
      System.out.println(Duration.between(start,end).toMillis());
  }

  public void test2(){
      LongStream.rangeClosed(0,100000000l).parallel().reduce(0,Long::sum);
  }
}