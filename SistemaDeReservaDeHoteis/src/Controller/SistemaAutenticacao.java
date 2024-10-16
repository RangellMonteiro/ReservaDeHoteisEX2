package Controller;

import Model.Administrador;
import Model.Cliente;
import Model.Usuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaAutenticacao {
    private ArrayList<Usuario> usuarios;

    public SistemaAutenticacao() {
        this.usuarios = new ArrayList<>();
    }

    // Método para cadastrar usuários
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario.getNome());
    }

    // Método para autenticar usuários
    public Usuario autenticar(String email, String senha, Class<? extends Usuario> tipoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)
                    && tipoUsuario.isInstance(usuario)) {
                return usuario; // Retorna o usuário autenticado se o tipo for compatível
            }
        }
        return null; // Retorna null se não encontrar o usuário
    }

    // Método para exibir o menu inicial com tratamento de exceções
    public void exibirMenuInicial() {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        do {
            try {
                System.out.println("Bem-vindo! Você é:\n1. Cliente (Hóspede)\n2. Administrador\n3. Sair");
                escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (escolha) {
                    case 1:
                        realizarLogin(Cliente.class); // Login para Hóspede
                        break;
                    case 2:
                        realizarLogin(Administrador.class); // Login para Administrador
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer
            }
        } while (escolha != 3);
    }

    // Método para realizar o login com base no tipo de usuário com tratamento de
    // exceções
    public void realizarLogin(Class<? extends Usuario> tipoUsuario) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();

            Usuario usuario = autenticar(email, senha, tipoUsuario);
            if (usuario != null) {
                System.out.println("Login realizado com sucesso!");
                usuario.exibirMenu(); // Exibe o menu específico de Cliente ou Administrador
            } else {
                System.out.println("Email, senha ou tipo de usuário incorretos.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a autenticação: " + e.getMessage());
        }
    }
}
