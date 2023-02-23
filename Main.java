import Entities.Usuario;
import Entities.Message;


import Services.MensagemService;
import Services.UsuarioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        UsuarioService usuarioService = UsuarioService.getInstance();
        MensagemService mensagemService = MensagemService.getInstance();

        String operacao = "";

        Scanner sc = new Scanner(System.in);

        while (!operacao.equals("4")) {
            System.out.println("Selecione a operação:\n " +
                    "1 - Criar Usuário \n " +
                    "2 - Criar Mensagem de Texto ou de Arquivo \n " +
                    "3 - Listar Mensagens \n" +
                    "4 - Sair");
            operacao = sc.next();

            if (operacao.equals("1")) {
                System.out.println("Informe o nome do Usuário: ");
                String nome = sc.next();
                usuarioService.createUser(nome);
                operacao = "";
            }
            else if (operacao.equals("2")) {
                operacao = "";
                while (!operacao.equals("3")) {
                    System.out.println("Selecione o tipo de mensagem a ser criado: \n" +
                            "1 - Mensagem de Texto \n" +
                            "2 - Mensagem de Arquivo \n" +
                            "3 - Sair");
                    operacao = sc.next();

                    if (operacao.equals("1")) {
                        System.out.println("Informe o nome do Usuário, e o conteúdo da mensagem:");

                        String nome = sc.next();
                        Usuario user = usuarioService.findUser(nome);

                        String content = sc.next();

                        String resultado = mensagemService.createTextMessage(user, content);
                        System.out.println(resultado);
                        operacao = "";

                    } else if (operacao.equals("2")) {
                        System.out.println("Informe o nome do Usuário, o conteúdo da mensagem e o tamanho do arquivo:");

                        String nome = sc.next();
                        Usuario user = usuarioService.findUser(nome);

                        String content = sc.next();

                        int size = sc.nextInt();

                        String resultado = mensagemService.createFileMessage(user, content, size);
                        System.out.println(resultado);
                        operacao = "";
                    }
                }
            }
            else if (operacao.equals("3")) {
                System.out.println("Informe o nome do Usuário");

                String nome = sc.next();
                Usuario user = usuarioService.findUser(nome);

                for (Message m : user.getMensagens()) {
                    System.out.println(m);
                }
                operacao = "";
            }
        }
    }
}
