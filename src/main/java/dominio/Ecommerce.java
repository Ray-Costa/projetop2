package dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class Ecommerce {
    private String nome;
    private ArrayList<Categoria> categorias;
    private Map<String, Vendedor> vendedorMap = new HashMap<String, Vendedor>();
    private Map<String, Administrador> administradorMap = new HashMap<String, Administrador>();
    private Map<String, Cliente> clienteMap = new HashMap<String, Cliente>();
    private ArrayList<Produto> produtos;

    public Ecommerce(String nome) {
        this.nome = nome;
        this.categorias = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void adicionarAdministrador(Administrador administrador) {
        administradorMap.put(administrador.getEmail(), administrador);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        vendedorMap.put(vendedor.getEmail(), vendedor);
    }

    public void adicionarCliente(Cliente cliente) {
        clienteMap.put(cliente.getEmail(), cliente);
    }

    public boolean adicionaCategoria(Categoria categoria) {
        if (getCategoriaPeloNome(categoria.getNome()) == null) {
            this.categorias.add(categoria);
            return true;
        } else {
            return false;
        }
    }

    public Categoria getCategoriaPeloNome(String nomeDaCategoria) {
        for (Categoria categoria1 : categorias) {
            if (categoria1 != null && categoria1.getNome().equals(nomeDaCategoria)) {
                return categoria1;
            }
        }

        return null;
    }

    public void listarCategorias() {
        for (int i = 0; i < this.categorias.size(); i++) {
            Categoria categoria = this.categorias.get(i);
            System.out.println((i + 1) + " . " + categoria.getNome() + "\n");
        }
    }

    public boolean removeCategorias(String nome) {
        for (Categoria categoria : this.categorias) {
            if (categoria.getNome().equals(nome)) {
                this.categorias.remove(categoria);
                return true;
            }
        }
        return false;
    }

    public Administrador loginAdministrador(String email, String senha) {
        if (administradorMap.containsKey(email)) {
            Administrador administrador = administradorMap.get(email);
            if (administrador.getSenha().equals(senha)) {
                return administrador;
            }
        }

        return null;
    }


    public Vendedor loginVendedor(String email, String senha) {
        if (vendedorMap.containsKey(email)) {
            Vendedor vendedor = vendedorMap.get(email);
            if (vendedor.getSenha().equals(senha)) {
                return vendedor;
            }
        }

        return null;
    }


    public Cliente loginCliente(String email, String senha) {
        if (clienteMap.containsKey(email)) {
            Cliente cliente = clienteMap.get(email);
            if (cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }

        return null;
    }

    public void listarProdutos() {
        for (int i = 0; i < this.produtos.size(); i++) {
            Produto produto = this.produtos.get(i);
            System.out.println(produto);
        }
    }

    public boolean adicionarProduto(Produto produto) {
        if (!produtoExiste(produto)) {
            this.produtos.add(produto);
            return true;
        } else {
            return false;
        }

    }

    private boolean produtoExiste(Produto produto) {
        for (Produto produto1 : produtos) {
            if (produto1 != null && produto1.equals(produto)) {
                return true;
            }
        }

        return false;
    }

    public boolean removeProdutos(String nome) {
        for (Produto produto : this.produtos) {
            if (produto.getNome().equals(nome)) {
                this.produtos.remove(produto);
                return true;
            }
        }
        return false;

    }

}
