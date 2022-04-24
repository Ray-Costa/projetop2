package dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CarrinhoDeCompras {
    private Ecommerce ecommerce;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private Envio envio;

    public CarrinhoDeCompras(Cliente cliente, Ecommerce ecommerce) {
        this.cliente = cliente;
        this.ecommerce = ecommerce;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProdutosAoCarrinho(Produto produto) {
        if (produto.getQtdDisponivel() < 1) {
            System.out.println("Produto Indisponivel");
        } else {
            this.produtos.add(produto);
        }
    }
}
