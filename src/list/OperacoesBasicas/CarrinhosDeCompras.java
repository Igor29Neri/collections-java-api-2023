package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhosDeCompras {
    //atributos
    private List<Item> itemList;

    public CarrinhosDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuant();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhosDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhosDeCompras carrinhosDeCompras = new CarrinhosDeCompras();

        // Adicionando itens ao carrinho
        carrinhosDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhosDeCompras.adicionarItem("Lápis", 2d, 3);
        carrinhosDeCompras.adicionarItem("Caderno", 35d, 1);
        carrinhosDeCompras.adicionarItem("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhosDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhosDeCompras.removerItem("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhosDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhosDeCompras.calcularValorTotal());
    }
}