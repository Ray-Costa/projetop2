package dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Vendedor extends Pessoa {

    private ArrayList<Produto> produtos;

    public Vendedor(String cpf, String nome, String email, String senha) {
        super(cpf, nome, email, senha);
        this.produtos = new ArrayList<>();
    }
}
