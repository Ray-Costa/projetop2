package dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Produto {
    private Integer id;
    private Double preco;
    private String nome;
    private String descricao;
    private Integer qtdDisponivel;
    private ArrayList<AvaliacaoProduto> avaliacoes;
    private Categoria categoria;
    private Vendedor vendedor;

    public Produto(String nome, Double preco, Integer qtdDisponivel, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.qtdDisponivel = qtdDisponivel;
        this.categoria = categoria;
        categoria.adicionarProduto(this);
    }

    public void adicionarAvaliacao(AvaliacaoProduto avaliacaoProduto) {
        this.avaliacoes.add(avaliacaoProduto);
    }


    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", qtdDisponivel=" + qtdDisponivel +
                ", categoria=" + categoria +
                '}';
    }
}
