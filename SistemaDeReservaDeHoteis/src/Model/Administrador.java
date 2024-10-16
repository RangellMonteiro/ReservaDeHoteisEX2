package Model;

public class Administrador extends Usuario {

    public Administrador(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Administrador: \n1. Gerenciar Reservas \n2. Gerenciar Quartos");
        // Implementar funcionalidades específicas para Administrador
    }
}
