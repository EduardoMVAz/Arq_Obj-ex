package Entities;

public class FileMessage extends Message {
    private String content;
    private Integer size;

    public FileMessage(Usuario user, String content, Integer size) {
        super(user);
        this.content = content;
        this.size = size;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String toString() {
        return content;
    }
}
