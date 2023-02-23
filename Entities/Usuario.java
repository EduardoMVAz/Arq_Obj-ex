package Entities;

import Entities.Message;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private List<Message> mensagens = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Message> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Message> mensagens) {
        this.mensagens = mensagens;
    }
}
