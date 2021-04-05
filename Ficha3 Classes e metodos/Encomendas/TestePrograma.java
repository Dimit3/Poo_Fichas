import java.time.LocalDate;
import java.util.Scanner;

// 1 - 9 - 7 - 8

public class TestePrograma {
    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        Linhadeencomenda arroz = new Linhadeencomenda("0001", "arroz agulha", 0.55, 2, 6, 0);
        String sArroz = arroz.toString();
        System.out.println(sArroz);
        Double totall1 = arroz.calculaValorLinhaEnc();
        System.out.println("Valor total: " + totall1 + "$");

        Linhadeencomenda massa = new Linhadeencomenda("0002", "massa esparguete",0.45,3,6,0);
        String sMassa = massa.toString();
        System.out.println(sMassa);
        Double totall2 = massa.calculaValorDesconto();
        System.out.println("Valor total: " + totall2 + "$");

        LocalDate x = LocalDate.parse("2020-03-06");
        LocalDate agora = LocalDate.now();
        LocalDate outradata = LocalDate.of(2020,3,6);
        LocalDate amanha = agora.plusDays(1);
        
        System.out.println("\n\n\n");
        Linhadeencomenda l [] = new Linhadeencomenda[2];
        l[0] = new Linhadeencomenda(arroz);
        l[1] = new Linhadeencomenda(massa);




        Encomenda first = new Encomenda("Daniel Ribeiro", 211088579, "Rua dos moreiros, Tamel S. Verissimo, Barcelos", 0001, agora, l);
        System.out.println (first);
        
        first.adicionaLinha(arroz);
        System.out.println(first);
        Boolean b = first.existeProdutoEncomenda(arroz.getReferencia());
        System.out.println(b);
        first.removeProduto(massa.getReferencia());
        System.out.println (first);

        Double t1 = first.calculaValorTotal();
        System.out.println(t1);


    }
}