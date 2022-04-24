package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class AvaliacaoProduto {
    private Integer nota;
    private String feedback;
    private Date data;
    private Cliente cliente;
    private Produto produto;

    public AvaliacaoProduto(Integer nota, String feedback, Date data, Cliente cliente, Produto produto) {
        this.nota = nota;
        this.feedback = feedback;
        this.data = data;
        this.cliente = cliente;
        this.produto = produto;
        produto.adicionarAvaliacao(this);
    }
}
