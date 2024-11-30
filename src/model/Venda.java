package model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Venda {

    private Item[] itens;
    private LocalDateTime dataHora;
    private int quantidadeItens;

    public Venda(){
        itens = new Item[3];
        dataHora = LocalDateTime.now();
        quantidadeItens = 0;
    }

    public double getTotal(){
        double total = 0;
        for(int i=0;i<quantidadeItens; i++){
            if(itens[i] != null){
                total += itens[i].getSubtotal();
            }else{
                total += 0;
            }
        }
        return total;
    }

    public boolean adicionarItem(Item item){
        if(quantidadeItens == itens.length){
            itens = Arrays.copyOf(itens, itens.length+3);
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public Item[] getItens(){
        return Arrays.copyOf(itens, quantidadeItens);
    }

    public boolean removerProd(double codigoProduto) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i] != null && itens[i].getCodigo() == codigoProduto) {
                for (int j = i; j < quantidadeItens - 1; j++) {
                    itens[j] = itens[j + 1];
                }
                itens[--quantidadeItens] = null;
                return true;
            }
        }
        return false;
    }

}