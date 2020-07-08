package Supermercado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrinho {
    private static Date dataCompra;
    private static String nomeCliente;
    private static double precoTotal;
    private List<Item> itens = new ArrayList<>();

    public Carrinho(Date dataCompra, String nomeCliente, double precototal) {
        this.dataCompra = dataCompra;
        this.nomeCliente = nomeCliente;
        this.precoTotal = precototal;
    }

    public Carrinho() {
    }

    public static Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public static String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public static double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;

    }

    public List<Item> getItens() {
        return itens;
    }

    public void addItem(Item item) {
        itens.add(item);
    }

    private void somarCompra() {
        double soma = 0.0;

        for (Item item : itens) {
            soma += item.getPrecototalItem();
        }
        setPrecoTotal(soma);
    }

    public void listaCompra() {
        somarCompra();
        ArrayList<String> itemLista = new ArrayList<>();

       
        itemLista.add("____________________________________________________\n");
        itemLista.add("Cliente: " + getNomeCliente());
        itemLista.add("Data: " + getDataCompra());
        itemLista.add("\nNº  Descrição  Qtde   Preço Unit. Preço total");

        for (Item item : itens) {
            double qtd = item.getQtd();
            double precoItem = item.getPrecototalItem();
            Produto produto = item.getProduto();
         
            itemLista.add(item.getNumitem() + " " + produto.getDescricao() + "  " + qtd + "   x   " + produto.getPrecounit() + "   =  " + precoItem);
        }
       
        itemLista.add("____________________________________________________\n");
        itemLista.add("Total  geral  da  compra:    R$ " + getPrecoTotal());
       
        imprimirTela(itemLista);

        imprimirArq(itemLista);
    }

    public static void imprimirArq(ArrayList<String> itemLista){
        GerarTxt geradorTxt = new GerarTxt(itemLista);
    }

    public static void imprimirTela(ArrayList<String> resumo){
        resumo.forEach(x -> System.out.println(x));

    }
}



