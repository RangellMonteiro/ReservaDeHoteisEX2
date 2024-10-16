package Model;

public class Cliente extends Usuario {

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public void exibirMenu() {
        System.out.println("Menu do Hóspede: \n1. Fazer Reserva \n2. Ver Reservas");
        // Implementar funcionalidades específicas para Hóspede
    }
}
