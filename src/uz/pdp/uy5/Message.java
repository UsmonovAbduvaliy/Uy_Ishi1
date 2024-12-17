package uz.pdp.uy5;

public class Message {
    private String message;
    private Integer userId;

    public Message(String message, Integer userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public Integer getUserId() {
        return userId;
    }
}
