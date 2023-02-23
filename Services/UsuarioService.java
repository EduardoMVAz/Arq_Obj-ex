package Services;

import Entities.Message;
import Entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private static UsuarioService usuarioService  = null;

    private UsuarioService () {}

    public static UsuarioService getInstance() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }
        return usuarioService;
    }

    private final static List<Usuario> usuarios = new ArrayList<>();

    public Usuario findUser(String nome){
        for (Usuario u : usuarios) {
            if (u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }

    public void createUser(String nome) {
        Usuario u = new Usuario(nome);
        UsuarioService.addUser(u);
    }

    public static List<Usuario> getUsuarios() {
        return UsuarioService.usuarios;
    }

    public static Usuario addUser(Usuario usuario) {
        if (usuario != null) {
            UsuarioService.usuarios.add(usuario);
        }
        return usuario;
    }

    public static void addMessage(Usuario user, Message message) {
        user.getMensagens().add(message);
    }
}
