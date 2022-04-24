package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = "produtos")
public class Categoria {
    private String nome;
    private ArrayList<Produto> produtos;

    public Categoria(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public Categoria() {

    }


    public void adicionarProduto(Produto produto) {
    }
}
