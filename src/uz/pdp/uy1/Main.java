package uz.pdp.uy1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static List<Integer> futures = new ArrayList<>();
    static ExecutorService executor = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        long start = System.currentTimeMillis();
//        int sum = 0;
//        for (int i = 0; i < 1_000_000; i++) {
//            sum += i;
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("Sum: " + sum);
//        System.out.println("Elapsed time: " + (end - start));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int s = i;
            Future<Integer> future = executor.submit(()->{
                int sum=0;
                for (int j = s*100_000; j <(s+1)*100_000 ; j++) sum += j;


                return sum;
            });
            while (true){
                if (future.isDone()) {
                    futures.add(future.get());
                    break;
                }
            }
        }
        Integer summ = 0;
        for (Integer future : futures) {
            summ+=future;
        }


        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(summ);
    }
}