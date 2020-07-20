package greet.greetingservice.model;

public class Greeting {
    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
