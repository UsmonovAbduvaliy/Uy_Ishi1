package uz.pdp.uy2;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class User implements Serializable {
    String phone;
    String password;
    ZoneId zoneId;

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
        for (Post post : DB.posts) {
            ZonedDateTime time = post.getDate().withZoneSameInstant(zoneId);
            System.out.println(post.getTitle()+" "+ time.getHour()+" : "+time.getMinute());
        }
    }
}
