import java.time.LocalDate;
import java.util.Scanner;

// 1 - 9 - 7 - 8

public class TestePrograma {

    public static int valido (String referencia, Linhadeencomenda l [] ){
        int i;

        for (i = 0; i < l.length; i++){ 
            if (l[i].getReferencia().equals(referencia))
                return i;
        }
        return -1;
    }


    public static void main (String [] args) {

        Scanner sc = new Scanner (System.in);

        Linhadeencomenda arroz = new Linhadeencomenda("0001", "arroz agulha", 0.55, 0, 6, 0);
        Linhadeencomenda massa = new Linhadeencomenda("0002", "massa esparguete",0.45,0,6,0);
        Linhadeencomenda gasPequeno = new Linhadeencomenda("0003", "garrafa gas pequena",(double)26,0,23,0);
        Linhadeencomenda gasGrande = new Linhadeencomenda("0004", "garrafa gas grande",(double)88,0,23,0);

        Linhadeencomenda l [] = new Linhadeencomenda[4];
        l[0] = new Linhadeencomenda(arroz);
        l[1] = new Linhadeencomenda(massa);
        l[2] = new Linhadeencomenda(gasPequeno);
        l[3] = new Linhadeencomenda(gasGrande);

        int v;

        System.out.println("Referencia do artigo");
        String referencia = sc.nextLine(); 
        int q = 0;
        while (valido(referencia, l) != -1){
            v = valido(referencia, l);
            System.out.println("Quantidade ");
            q = sc.nextInt();
            l[v].setQuantidade(q);
            System.out.println("Referencia do artigo");
            referencia = sc.next();
        }







/*      String sArroz = arroz.toString();
        System.out.println(sArroz);
        Double totall1 = arroz.calculaValorLinhaEnc();
        System.out.println("Valor total: " + totall1 + "$");
        String sMassa = massa.toString();
        System.out.println(sMassa);
        Double totall2 = massa.calculaValorLinhaEnc());
        System.out.println("Valor total: " + totall2 + "$"); */

        LocalDate x = LocalDate.parse("2020-03-06");
        LocalDate agora = LocalDate.now();
        LocalDate outradata = LocalDate.of(2020,3,6);
        LocalDate amanha = agora.plusDays(1);
        
        System.out.println("\n\n\n");


        Encomenda first = new Encomenda("Daniel Ribeiro", 211088579, "Rua dos moreiros, Tamel S. Verissimo, Barcelos", 0001, agora, l);
        
        
        
        System.out.println (first);
    }
}