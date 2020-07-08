package Supermercado;

import java.util.*;

import Exceptions.ProductExeption;

public class Mercado {
    public static void main(String[] args) throws ProductExeption {
        List<Produto> produtos = new ArrayList<>();
        produtos = Controlador.gerarProdutos();
        comecarProcesso(produtos);
    }

    private static void comecarProcesso(List<Produto> produtos) throws ProductExeption {
        Carrinho carrinho = new Carrinho();
        int indice = 0;
        boolean flag = true;

        String nomeCliente = Controlador.nomeCliente();
        carrinho.setNomeCliente(nomeCliente);
        carrinho.setDataCompra(new Date(System.currentTimeMillis()));

        while (flag) {
            try {
                Controlador.produtos(produtos);
                Produto prod = Controlador.colocarNoCarrinho(produtos).get(0);
                int qtd = Controlador.Qtde();

                if (prod != null) {
                    indice++;
                    carrinho.addItem(new Item(indice, prod, qtd));
                } else {
                    throw new ProductExeption("Produto Inexistente");
                }
                flag = Controlador.compra();

            } catch (Exception e) {
                System.out.println("Produto Inexistente");
            }
        }
        Controlador.visualizarCompra(carrinho);
    }

}