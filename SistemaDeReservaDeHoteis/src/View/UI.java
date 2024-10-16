package View;

import Controller.SistemaAutenticacao;
import Model.Administrador;
import Model.Usuario;
import Model.Cliente;

public class UI {
    public static void main(String[] args) {
        // Criando uma instância do sistema de autenticação
        SistemaAutenticacao sistema = new SistemaAutenticacao();

        // Cadastrando alguns usuários para teste
        Usuario cliente1 = new Cliente("João", "joao@email.com", "senha123");
        Usuario admin1 = new Administrador("Maria", "maria@admin.com", "admin123");

        // Adicionando os usuários cadastrados ao sistema de autenticação
        sistema.cadastrarUsuario(cliente1);
        sistema.cadastrarUsuario(admin1);

        // Exibindo o menu inicial que pergunta se o usuário é Cliente ou Administrador
        sistema.exibirMenuInicial();
    }
}
