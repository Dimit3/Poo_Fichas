import java.time.LocalDate;
import java.util.Scanner;


public class TestePrograma {
    public static void main (String [] args) {

        Linhadeencomenda arroz = new Linhadeencomenda("0001", "arroz agulha", 0.55, 2, 6, 0);
        System.out.println(arroz + "\n");

        Linhadeencomenda massa = new Linhadeencomenda("0002", "massa esparguete",0.45,3,6,0);
        System.out.println(massa);

        //LocalDate x = LocalDate.parse("2020-03-06");
        //LocalDate outradata = LocalDate.of(2020,3,6);
        //LocalDate amanha = agora.plusDays(1);
        
        System.out.println("\n\n\n");


        LocalDate agora = LocalDate.now();

        EncEficiente firstEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", 0001, agora);
        firstEnc.adicionaLinha(arroz.clone());
        firstEnc.adicionaLinha(massa.clone());
        System.out.println (firstEnc);

        EncEficiente secondEnc = new EncEficiente(firstEnc.clone()); 
        System.out.println(firstEnc.equals(secondEnc));

        secondEnc.adicionaLinha(massa.clone());
        System.out.println(secondEnc.equals(firstEnc));

        System.out.println(firstEnc.calculaValorTotal());
        System.out.println(secondEnc.calculaValorTotal());

        System.out.println(firstEnc.calculaValorDesconto());
        System.out.println(secondEnc.calculaValorDesconto());

        System.out.println(firstEnc.numeroTotalProdutos());
        System.out.println(secondEnc.numeroTotalProdutos());

        System.out.println(firstEnc.existeProdutoEncomenda("0002"));
        firstEnc.removeProduto("0002");
        System.out.println(firstEnc);
        System.out.println(firstEnc.existeProdutoEncomenda("0002"));

    }
}