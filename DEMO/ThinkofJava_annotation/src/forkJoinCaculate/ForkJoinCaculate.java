package forkJoinCaculate;


import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * https://www.bilibili.com/video/av62117143?p=14
 *
 */

public class ForkJoinCaculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1234567889L;
    private long start;
    private long end;

    private static final long THRESHOLD =10000;

    public ForkJoinCaculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     *
     *
     * @return
     *
     */



    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THRESHOLD){
            long sum = 0;
            for(long i = start; i<=end; i++){
               sum+=i;
            }
            return sum;
        }else{
            long middle=(start+end)/2; //20 ,30 -> 25,25   1,9->5,5
            ForkJoinCaculate left = new ForkJoinCaculate(start,middle);
            left.fork();//拆分子任务,同时压入先程序列

            ForkJoinCaculate right = new ForkJoinCaculate(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }
    }
}

class TestForkJoin{
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCaculate(0,10000000000l);

        long sum = pool.invoke(task);
        pool.submit(task);

        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费:"+ Duration.between(start,end).toMillis());
    }
}