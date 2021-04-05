import java.time.LocalDate;
import java.util.Map;
import java.util.List;



public class TestePrograma {
    public static void main (String [] args) {

        Linhadeencomenda arroz = new Linhadeencomenda("0001", "arroz agulha", 0.55, 2, 6, 0);
        Linhadeencomenda massa = new Linhadeencomenda("0002", "massa esparguete",0.45,3,6,0);
        Linhadeencomenda azeite = new Linhadeencomenda("0003", "azeite", 0.55, 2, 6, 0);
        Linhadeencomenda cafe = new Linhadeencomenda("0004", "cafe",0.45,3,6,0);
        Linhadeencomenda leite = new Linhadeencomenda("0005", "leite", 0.55, 2, 6, 0);
        Linhadeencomenda cola = new Linhadeencomenda("0006", "cola",0.45,3,6,0);

        LocalDate agora = LocalDate.now();
        LocalDate x = LocalDate.parse("2020-03-06");
        LocalDate outradata = LocalDate.of(2020,3,6);
        LocalDate amanha = agora.plusDays(1);

        EncEficiente firstEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0001", agora);
        EncEficiente secEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0002", outradata);
        EncEficiente thirdEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0003", x);
        EncEficiente fourthEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0004", x);
        EncEficiente fiftEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0005", amanha);
        EncEficiente sixtEnc = new EncEficiente("Daniel Ribeiro", 123456789, "Barcelos", "0006", amanha);
        firstEnc.adicionaLinha(arroz);
        secEnc.adicionaLinha(arroz);
        thirdEnc.adicionaLinha(arroz);
        thirdEnc.adicionaLinha(massa);
        fourthEnc.adicionaLinha(arroz);
        fourthEnc.adicionaLinha(leite);
        fourthEnc.adicionaLinha(cafe);
        fourthEnc.adicionaLinha(arroz);
        fourthEnc.adicionaLinha(leite);
        fourthEnc.adicionaLinha(cafe);
        fourthEnc.adicionaLinha(cafe);        
        fiftEnc.adicionaLinha(cafe);
        fiftEnc.adicionaLinha(azeite);
        firstEnc.adicionaLinha(azeite);
        fiftEnc.adicionaLinha(cola);

        GestaoEncomendas g = new GestaoEncomendas();
        g.addEncomenda(firstEnc);
        g.addEncomenda(secEnc);
        g.addEncomenda(thirdEnc);
        g.addEncomenda(fourthEnc);
        g.addEncomenda(fiftEnc);
        Map<String,List<String>> duh; 

        duh = g.encomendasDeProduto();
        
        System.out.println(duh);


    }
}