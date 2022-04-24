import dominio.Administrador;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Ecommerce;
import dominio.Produto;
import dominio.Vendedor;

import java.util.Scanner;

public class Main {
    private static final Integer LOGIN_MENU_PRINCIPAL = 1;
    private static final Integer CADASTRO_MENU_PRINCIPAL = 2;
    private static final Integer SAIR = 3;
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Ecommerce ecommerce = new Ecommerce("Loja da Renata");

        Vendedor vendedorTeste = new Vendedor("084750231", "Joao Pedro", "v", "2");
        ecommerce.adicionarVendedor(vendedorTeste);


        Administrador administrador = new Administrador("08475056423", "Marcos Arruda", "m", "1");
        ecommerce.adicionarAdministrador(administrador);

        Cliente clienteTeste = new Cliente("084750564", "Maria", "r", "3");
        ecommerce.adicionarCliente(clienteTeste);


        System.out.println("Bem-Vindo a " + ecommerce.getNome());
        imprimirMenuPrincipal();
        Integer opcaoMenuPrincipal = atualizarOpcaoMenuPrincipal();

        while (!opcaoMenuPrincipal.equals(SAIR)) {

            if (opcaoMenuPrincipal.equals(LOGIN_MENU_PRINCIPAL)) {
                String email = getEmailDoUsuario();

                String senha = getSenhaDoUsuario();

                Administrador administradorLogado = ecommerce.loginAdministrador(email, senha);
                Vendedor vendedorLogado = ecommerce.loginVendedor(email, senha);
                Cliente clienteLogado = ecommerce.loginCliente(email, senha);

                //Se o usuario logado é adm, mostrar opcoes de categorias
                if (administradorLogado != null) {
                    opcaoMenuPrincipal = 10;
                }

                //Se o usuario é vendedor, mostra opcoes de criar produto, e add em categorias
                else if (vendedorLogado != null) {
                    opcaoMenuPrincipal = 11;
                }

                //Se o usuario é cliente, mostra categorias e opcaoMenuPrincipal de busca, depois de finalizacao.
                else if (clienteLogado != null) {
                    opcaoMenuPrincipal = 12;
                }

                // Se não é nenhum, então ele não existe
                else {
                    System.out.println("E-mail e senha inválidos");
                }


            } else if (opcaoMenuPrincipal.equals(CADASTRO_MENU_PRINCIPAL)) {
                System.out.println("1. Vendedor\n2. Cliente\n3. Voltar");
                opcaoMenuPrincipal = atualizarOpcaoMenuPrincipal();

                String nome = getNomeDoUsuario();
                String email = getEmailDoUsuario();
                String senha = getSenhaDoUsuario();
                String cpf = getCPFDoUsuario();

                if (opcaoMenuPrincipal == 1) {
                    Vendedor vendedor = new Vendedor(cpf, nome, email, senha);
                    ecommerce.adicionarVendedor(vendedor);
                } else {
                    Cliente cliente = new Cliente(cpf, nome, email, senha);
                    ecommerce.adicionarCliente(cliente);
                }

                imprimirMenuPrincipal();
                opcaoMenuPrincipal = atualizarOpcaoMenuPrincipal();

            } else if (opcaoMenuPrincipal == 10) {
                System.out.println("Bem vindo administrador\nDigite 1 para listar categorias\nDigite 2 para criar categorias\nDigite 3 para remover categorias\nDigite 4 para sair");
                int subOpcaoAdm = Integer.parseInt(scanner.nextLine());

                if (subOpcaoAdm == 1) {
                    ecommerce.listarCategorias();
                } else if (subOpcaoAdm == 2) {
                    System.out.println("Digite o nome da nova categoria");
                    String nome = scanner.nextLine();
                    criarCategoria(ecommerce, nome);
                } else if (subOpcaoAdm == 3) {
                    System.out.println("Digite o nome da categoria");
                    String nome = scanner.nextLine();
                    ecommerce.removeCategorias(nome);
                    System.out.println("Categoria removida com sucesso!");
                } else if (subOpcaoAdm == 4) {
                    System.out.println("Logout!");
                    opcaoMenuPrincipal = 3;
                }
            } else if (opcaoMenuPrincipal == 11) {
                System.out.println("Bem Vindo vendedor\nDigite 1 para listar produtos\nDigite 2 para criar produtos\nDigite 3 para remover produtos\nDigite 4 para sair");
                int subOpcaoVend = Integer.parseInt(scanner.nextLine());

                if (subOpcaoVend == 1) {
                    ecommerce.listarProdutos();

                } else if (subOpcaoVend == 2) {
                    System.out.println("Digite o nome da categoria");
                    String nomeCategoria = scanner.nextLine();
                    Categoria categoriaExistente = ecommerce.getCategoriaPeloNome(nomeCategoria);
                    if (categoriaExistente != null) {
                        criarProduto(ecommerce, categoriaExistente);
                    } else {
                        System.out.println("Categoria não existe, deseja criá-la? Digite: ");
                        System.out.println("1.Sim\n2.Não");
                        String num = scanner.nextLine();
                        if (num.equals("1")) {
                            Categoria categoriaCriada = criarCategoria(ecommerce, nomeCategoria);
                            Produto produto = criarProduto(ecommerce, categoriaCriada);
                            System.out.println(ecommerce.getProdutos());
                        }
                    }

                } else if (subOpcaoVend == 3) {
                    System.out.println("Digite o nome do produto");
                    String nome = scanner.nextLine();
                    ecommerce.removeProdutos(nome);
                    System.out.println("Produto removido com sucesso!");

                } else if (subOpcaoVend == 4) {
                    System.out.println("Logout!");
                    opcaoMenuPrincipal = 3;
                }


            } else if (opcaoMenuPrincipal == 12) {
                System.out.println("Bem Vindo Cliente!");
                String nome = scanner.nextLine();


            }
        }
    }

    private static String getCPFDoUsuario() {
        System.out.println("Digite o seu cpf: ");
        return scanner.nextLine();
    }

    private static String getNomeDoUsuario() {
        System.out.println("Digite o seu nome: ");
        return scanner.nextLine();
    }

    private static String getSenhaDoUsuario() {
        System.out.println("Digite sua senha: ");
        return scanner.nextLine();
    }

    private static String getEmailDoUsuario() {
        System.out.println("Digite o seu email: ");
        return scanner.nextLine();
    }

    private static Integer atualizarOpcaoMenuPrincipal() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void imprimirMenuPrincipal() {
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Login\n2. Cadastro\n3. Sair");
    }

    private static Categoria criarCategoria(Ecommerce ecommerce, String nome) {
        Categoria categoria = new Categoria(nome);
        ecommerce.adicionaCategoria(categoria);
        System.out.println("Categoria criada com sucesso!");
        return categoria;
    }

    private static Produto criarProduto(Ecommerce ecommerce, Categoria categoria) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do novo produto");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço");
        String preco = scanner.nextLine();
        System.out.println("Digite a quantidade");
        String qtdDisponivel = scanner.nextLine();

        Produto produto = new Produto(nome, Double.parseDouble(preco), Integer.parseInt(qtdDisponivel), categoria);
        ecommerce.adicionarProduto(produto);
        System.out.println("Produto criado com sucesso!");
        return produto;
    }
}