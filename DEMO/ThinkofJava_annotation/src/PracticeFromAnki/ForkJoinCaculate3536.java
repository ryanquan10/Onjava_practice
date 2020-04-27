package PracticeFromAnki;

import functional.exersices.ForkJoinCalculate;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCaculate3536 extends RecursiveTask<Long> {
    private static final long serialVersionUID = 343525L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000;

    public ForkJoinCaculate3536(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end-start;
        if(length<=THRESHOLD){
            long sum = 0;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long middle=(start+end)/2;
            ForkJoinCaculate left = new ForkJoinCaculate(start,middle);
            left.fork();

            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,length);
            right.fork();
        }
        return null;
    }
}
