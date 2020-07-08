package Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controlador {

    static String nomeCliente() {
        System.out.println("Digite seu nome para iniciar as compras: \n ");
        Scanner sc = new Scanner(System.in);
        String nome = sc.next();
        return nome;
    }

    public static void produtos(List<Produto> produtos){
    	System.out.println("\n");
    	System.out.println("P r o d u t o s");
    	System.out.println("Cód. Descricao  Valor Unit.");
        for (Produto produto : produtos){
            String mensagem = produto.toString();
            System.out.println(mensagem);
        }
    }

    public static List<Produto> colocarNoCarrinho(List<Produto> produtos){
        System.out.println("\nEscolha o produto pelo código\n");
        Scanner scan = new Scanner(System.in);
        int escolha = scan.nextInt();
        List<Produto> produto= produtos.stream().filter(x -> x.getCodigo() == escolha).collect(Collectors.toList());

        return produto;
    }

    public static int Qtde(){
        System.out.println("Quantidade: \n");
        Scanner scan = new Scanner(System.in);
        int qtd = scan.nextInt();

        return qtd;
    }
    
    public static boolean compra(){
        System.out.println("Continuar comprando?\n Digite: \n | Sim |   ou   |Não|\n");
        Scanner scan = new Scanner(System.in);
        String resp = scan.next();
        if (resp.equals("s") || resp.equals("S") || resp.equals("sim") || resp.equals("Sim") || resp.equals("SIM")){
            return true;
        }else {
            return false;
        }
    }

    public static void visualizarCompra(Carrinho carrinho){
        carrinho.listaCompra();
    }

    public static List<Produto> gerarProdutos(){
        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto(1 , "Alface      ", 2.60); produtos.add(produto1);
        Produto produto2 = new Produto(2 , "Cenoura     ", 3.40); produtos.add(produto2);
        Produto produto3 = new Produto(3 , "Detergente  ", 5.60); produtos.add(produto3);        
        Produto produto4 = new Produto(4 , "Biscoito    ", 2.20); produtos.add(produto4);        
        Produto produto5 = new Produto(5 , "Sabao em po ", 8.40); produtos.add(produto5);

           
       return produtos;
    }
}
