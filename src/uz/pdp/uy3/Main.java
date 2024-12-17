package uz.pdp.uy3;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[]{"book"," pen", "ruler", "note", "laptop", "window"};
        Random rand = new Random();
        File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy3\\a.txt");
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        for (int i = 0; i < 1000; i++) {
            try(
                    FileOutputStream os = new FileOutputStream(file,true);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                    ) {
                bw.write(str[rand.nextInt(str.length)]);
                bw.newLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        while (true){
            System.out.println("""
                    1 - Remove Books.
                    2 - Remove Pens.
                    """);
            switch (sc.nextInt()){
                case 1->removeBooks();
                case 2->removePens();
                default -> System.out.println("Invalid Option");
            }
        }
    }

    private static void removeBooks() throws IOException {
        String wordToRemove = "book";
        File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy3\\a.txt");
        File file1 = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy3\\test.txt");
        if(file1.exists()){
            file1.delete();
        }
        file1.createNewFile();
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file1)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("(?i)\\b" + wordToRemove + "\\b", "");
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        }
        file.delete();
        file.createNewFile();
        try (FileInputStream fis = new FileInputStream(file1);
             FileOutputStream fos = new FileOutputStream(file)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            while ((reader.readLine()) != null) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            writer.flush();
        }
    }

    private static void removePens() throws IOException {
        String wordToRemove = "pen";
        File file = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy3\\a.txt");
        File file1 = new File("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy3\\test.txt");
        if(file1.exists()){
            file1.delete();
        }
        file1.createNewFile();
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file1)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("(?i)\\b" + wordToRemove + "\\b", "");
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        }
        file.delete();
        file.createNewFile();
        try (FileInputStream fis = new FileInputStream(file1);
             FileOutputStream fos = new FileOutputStream(file)) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            while ((reader.readLine()) != null) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            writer.flush();
        }
    }
}
