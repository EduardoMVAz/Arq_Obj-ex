package Services;

import Entities.FileMessage;
import Entities.Message;
import Entities.TextMessage;
import Entities.Usuario;

public class MensagemService {

    private static MensagemService mensagemService = null;

    private MensagemService() {
    }

    public static MensagemService getInstance() {
        if (mensagemService == null) {
            mensagemService = new MensagemService();
        }
        return mensagemService;
    }

    public Boolean verifyUser(Usuario user) {
        for (Usuario u : UsuarioService.getUsuarios()) {
            if (u == user) {
                return true;
            }
        }
        return false;
    }

    public String createTextMessage(Usuario user, String content) {
        if (verifyUser(user)) {
            TextMessage message = new TextMessage(user, content);
            UsuarioService.addMessage(user, message);
            return "Mensagem publicada com sucesso!";
        }
        return "Falha na publicação da mensagem";
    }

    public String createFileMessage(Usuario user, String content, Integer size) {
        if (verifyUser(user)) {
            FileMessage message = new FileMessage(user, content, size);
            UsuarioService.addMessage(user, message);
            return "Mensagem publicada com sucesso!";
        }
        return "Falha na publicação da mensagem";
    }
}

