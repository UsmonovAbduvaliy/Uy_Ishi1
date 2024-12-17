package uz.pdp.uy2;

import java.time.ZonedDateTime;

public class Post {
    private String title;
    private ZonedDateTime date;

    public Post(String title, ZonedDateTime date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public ZonedDateTime getDate() {
        return date;
    }
}
