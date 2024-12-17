package uz.pdp.uy2;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public interface DB {
    List<Post> posts = List.of(
            new Post("Post 1", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 2", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 3", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 4", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 5", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 6", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 7", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 8", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 9", ZonedDateTime.now(ZoneId.systemDefault())),
            new Post("Post 10", ZonedDateTime.now(ZoneId.systemDefault()))
    );
}
