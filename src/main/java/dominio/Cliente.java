package dominio;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Produto> produtos;

    public Cliente(String cpf, String nome, String email, String senha) {
        super(cpf, nome, email, senha);
        this.produtos = new ArrayList<>();
    }
}
