package uz.pdp.uy5;

import java.io.*;
import java.time.ZoneId;

public class User implements Serializable {
    Integer id = generic++;
    String phone;
    String password;
    ZoneId zoneId;
    static int generic = 1;

    public User(String phone, String password, ZoneId zoneId) {
        this.phone = phone;
        this.password = password;
        this.zoneId = zoneId;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void menu() {
        while (true) {
            try (
                    ObjectInputStream fileInputStream = new ObjectInputStream(
                            new FileInputStream("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy5\\message_DB.txt"))
            ) {

                if(fileInputStream.read()!=0) {
                    while (true) {
                        try {
                            Message o = (Message) fileInputStream.readObject();
                            if (o.getUserId().equals(id)) {
                                System.out.println(o.getMessage());
                            }
                        } catch (EOFException e) {
                            break;
                        }
                    }
                }else {
                    System.out.println("Siz uchun xabar topilmadi.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Fayl topilmadi. Iltimos, izoh qo'shing.");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            System.out.println("""
                    \n
                    1 - Add comment.
                    2 - Logout.
                    """);
            switch (Input.num("Choose: ")) {
                case 1->addComment();
                case 2->{
                    return;
                }
            }
        }
    }

    private void addComment() {
        String message = Input.str("Enter comment: ");
        try(
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy5\\message_DB.txt"))
                ){
            outputStream.writeObject(new Message(message,id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
