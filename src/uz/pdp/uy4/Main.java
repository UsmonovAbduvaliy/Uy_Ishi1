package uz.pdp.uy4;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static ExecutorService service = Executors.newFixedThreadPool(3);
    static long count = 0;
    public static void main(String[] args) throws InterruptedException {
     service.execute(()->{
         long sum =0;
         for (int i = 0; i < 1_000_000; i++) {
             sum+=i;
         }
         try(
                 FileWriter writer = new FileWriter("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a1.txt");
                 ) {
             writer.write(String.valueOf(sum));
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }); service.execute(()->{
         long sum =0;
         for (int i = 1_000_000; i < 2_000_000; i++) {
             sum+=i;
         }
         try(
                 FileWriter writer = new FileWriter("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a2.txt");
                 ) {
             writer.write(String.valueOf(sum));
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }); service.execute(()->{
         long sum =0;
         for (int i = 2_000_000; i < 3_000_000; i++) {
             sum+=i;
         }
         try(
                FileWriter writer = new FileWriter("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a3.txt")
                 ) {
             writer.write(String.valueOf(sum));
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     });

     service.awaitTermination(100, TimeUnit.MILLISECONDS);
        try (
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a1.txt"));
                BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a2.txt"));
                BufferedReader reader3 = new BufferedReader(new FileReader("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy4\\a3.txt"));

        ) {
            String line = reader.readLine();
            String line2 = reader2.readLine();
            String line3 = reader3.readLine();

            long sum = Long.parseLong(line.replaceAll("[^0-9]", ""));
            long sum2 = Long.parseLong(line2.replaceAll("[^0-9]", ""));
            long sum3 = Long.parseLong(line3.replaceAll("[^0-9]", ""));

           count+=sum;
           count+=sum2;
           count+=sum3;
     } catch (Exception e) {
         throw new RuntimeException(e);
     }

        System.out.println(count);
    }
}
