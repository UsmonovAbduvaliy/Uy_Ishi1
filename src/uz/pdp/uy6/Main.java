package uz.pdp.uy6;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[]{"book", "pen", "ruler", "note", "laptop", "window"};
        int index = 0;
        File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy6\\pdp.txt");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        for (int i = 0; i < 10_000; i++) {
            try (
                    FileOutputStream os = new FileOutputStream(file, true);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            ) {
                if(index==6){
                    index=0;
                }
                bw.write(str[index++]);
                bw.newLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        while (true) {
            System.out.println("""
                    1 - Counter of Books.
                    2 - Counter of Pens.
                    """);
            switch (sc.nextInt()) {
                case 1 -> countBooks();
                case 2 -> countPens();
                default -> System.out.println("Invalid Option");
            }
        }
    }

    private static void countBooks() throws IOException {
        service.execute(() -> {
            int counterBooks = 0;
            File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy6\\pdp.txt");
            File file1 = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy6\\test1.txt");
            if (file1.exists()) {
                file1.delete();
            }
            try {
                file1.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (FileInputStream fis = new FileInputStream(file);
                 FileOutputStream fos = new FileOutputStream(file1)) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.equals("book")){
                        counterBooks++;
                    }
                }
                writer.write(String.valueOf(counterBooks));
                System.out.println("Counter of books: "+counterBooks);
                writer.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

    }

    private static void countPens() throws IOException {
        service.execute(() -> {
            int counterPens = 0;
            File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy6\\pdp.txt");
            File file1 = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy6\\test1.txt");
            if (file1.exists()) {
                file1.delete();
            }
            try {
                file1.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (FileInputStream fis = new FileInputStream(file);
                 FileOutputStream fos = new FileOutputStream(file1)) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.equals("pen")){
                        counterPens++;
                    }
                }
                writer.write(String.valueOf(counterPens));
                System.out.println("Counter of pen: "+counterPens);
                writer.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

    }
}

