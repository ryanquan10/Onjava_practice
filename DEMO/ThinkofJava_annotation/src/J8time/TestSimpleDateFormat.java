package J8time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> task = new Callable<Date>(){
            @Override
            public Date call() throws Exception {
                return sdf.parse ("20111218");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = new ArrayList<>();
        for(int i=0;i<10;i++){
            results.add(pool.submit(task));
        }

        for(Future<Date> future:results){
            System.out.println(future.get());
        }
    }
}
