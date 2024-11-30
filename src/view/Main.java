package view;

import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Venda venda = new Venda();

        int opcao;
        int codigoI, codigoP;
        String descricao;
        double preco;
        int quantidade;
        double codigoIExclusao;

        do {
            System.out.println("\nEscolha uma opção: \n"+
                    "1- Adicionar um produto \n" +
                    "2- Remover produto: \n" +
                    "3- Mostrar total da compra\n" +
                    "4- Sair do programa:" );

            Scanner scanner = new Scanner(System.in);
            System.out.println("Escolha uma opção: \n");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("\nAdicionar o código do item: \n");
                    codigoI = scanner.nextInt();
                    System.out.println("Adicionar o código do produto: \n");
                    codigoP = scanner.nextInt();
                    System.out.println("Adionar descrição do produto: \n");
                    descricao = scanner.next();
                    System.out.println("Adicionar o preço do produto: \n");
                    preco = scanner.nextDouble();
                    System.out.println("Adicionar o quantidade do produto: \n");
                    quantidade = scanner.nextInt();


                    venda.adicionarItem(
                            new Item(codigoI,
                                    new Produto(codigoP, descricao,
                                            preco, Categoria.ALIMENTICIO),
                                    quantidade)
                    );
                    break;

                case 2:
                    System.out.println("Informe o codigo do item que quer remover: ");
                    codigoIExclusao = scanner.nextDouble();
                    venda.removerProd(codigoIExclusao);
                case 3:
                    System.out.println(venda.getTotal());
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while (opcao !=4);
    }
}