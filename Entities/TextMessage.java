package Entities;

import Entities.Message;

public class TextMessage extends Message {
    private String content;

    public TextMessage(Usuario user, String content) {
        super(user);
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString(){
        return content;
    }
}
