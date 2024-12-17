package uz.pdp.uy5;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("""
                    1 - Login.
                    2 - Register.
                    """);
            switch (Input.num("Choose: ")) {
                case 1->loginUser();
                case 2->registerUser();
            }

        }
    }

    private static void loginUser() {
        String phone;
        String password;
        while (true) {
            while (true) {
                phone = Input.str("0-Back.\nEnter Phone Number");
                if(phone.equals("0"))return;
                password = Input.str("0-Back.\nEnter Password");
                if(password.equals("0"))return;
                if(phone.matches("\\+998\\d{9}")&&password.matches("[a-zA-Z0-9\\D]+")){
                    break;
                }else {
                    System.out.println("Invalid Phone Number or Password");
                }
            }
            try(
                    ObjectInputStream ios = new ObjectInputStream(new FileInputStream("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy5\\user_DB.txt"))
            ) {
                Object o = ios.readObject();
                User user = (User) o;
                if(user.phone.equals(phone)&&user.password.equals(password)) {
                    user.menu();
                }else {
                    System.out.println("Invalid Phone Number or Password");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static ZoneId zoneIdTanlash() {
        System.out.println("""
                1 - Moscow
                2 - Tokyo
                3 - New-York
                4 - Sydney
                """);
        switch (Input.num("Choose: ")) {
            case 1-> {
                return ZoneId.of("Europe/Moscow");
            }
            case 2-> {
                return ZoneId.of("Asia/Tokyo");
            }
            case 3->{
                return ZoneId.of("America/New_York");
            }
            case 4->{
                return ZoneId.of("Australia/Sydney");
            }
        }
        return ZoneId.systemDefault();
    }

    private static void registerUser() {
        String phone = "";
        String password = "";
        while (true) {
            phone = Input.str("0-Back.\nEnter Phone Number");
            if (phone.equals("0")) {
                return;
            }
            password = Input.str("0-Back.\nEnter Password");
            if (password.equals("0")) {
                return;
            }
            if(phone.matches("\\+998\\d{9}")&&password.matches("[a-zA-Z0-9\\D]+")){
                break;
            }else {
                System.out.println("Invalid Phone Number or Password");
            }
        }
        ZoneId zoneId = zoneIdTanlash();

        try(
                ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Abduvaliy\\IdeaProjects\\4M Lesson 8\\src\\uz\\pdp\\uy5\\user_DB.txt"))
        ) {
            oos.writeObject(new User(phone, password, zoneId));
            System.out.println("Register Successful");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
