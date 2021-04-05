import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestePrograma  {
    public static void main(String[] args) throws IOException, ClassNotFoundException, VeiculoRepetidoException, VeiculoNaoExistenteException,
            ValorInvalidoException {
        List<Integer> classificacao1= new ArrayList<>();
        classificacao1.add(5);
        classificacao1.add(10);
        classificacao1.add(8);

        List<Integer> classificacao2= new ArrayList<>();
        classificacao2.add(9);
        classificacao2.add(10);
        classificacao2.add(7);

        Veiculo v1 = new VeiculoNormal("aa-11-00", "Ford", "Mustang",2019,20,20,classificacao1);
        Veiculo v2 = new VeiculoNormal("aa-11-01", "Audi", "A3",2018,10,15,classificacao2);

        classificacao1.add(6);
        classificacao1.add(4);
        classificacao1.add(1);
        Veiculo v3 = new VeiculoNormal("aa-11-03", "Ford", "Fiesta",2018,5,10,classificacao1);

        classificacao2.add(1);
        classificacao2.add(3);
        classificacao2.add(10);
        Veiculo v4 = new VeiculoNormal("aa-11-04", "Seat", "Ibiza",2018,5,10,classificacao2);

        //System.out.println(v1);

        DriveIt d1 = new DriveIt();
        d1.add(v1);
        d1.add(v2);

        DriveIt d2 = new DriveIt();
        d2.add(v1);
        d2.add(v3);
        d2.add(v4);

        System.out.println(d1.existeVeiculo("aa-11-03"));
        System.out.println(d2.existeVeiculo("aa-11-03"));

        System.out.println(d1.quantos());
        System.out.println(d2.quantos());
        System.out.println(d1.quantos("Ford"));
        System.out.println(d2.quantos("Ford"));

        System.out.println(d1.getVeiculo("aa-11-00"));
        //System.out.println(d1.getVeiculo("aa-11-03"));
        System.out.println(d1.getVeiculos());

        Set<Veiculo> c1=new TreeSet<>((x,y)->x.getIdentificacao().compareTo(y.getIdentificacao()));
        c1.add(v3);
        c1.add(v4);
        System.out.println("\n\n\n\n");
        d1.adiciona(c1);
        System.out.print(d1);
  

        System.out.println("\n\n\n\n"); 
        System.out.print(d1);
        System.out.print(v1);
        d1.classificarVeiculo("aa-11-00", 100);
        System.out.println("\n\n\n\n"); 
        System.out.print(d1);
        System.out.print(v1);
        
        System.out.println("\n\n\n\n"); 
        System.out.print(d1);
        System.out.println("\n\n\n\n"); 
        

        VeiculoNormal lambo = new VeiculoNormal ("22-QW-33" ,"Lamborghini","Huracan",2020,150.0 , 100.0 , new ArrayList<Integer>());
        VeiculoPremium ferrari = new VeiculoPremium ("62-PR-22" ,"Ferrari","488",2020, 130 , 80 , new ArrayList<>(),25);
        VeiculoOcasiao ocasiao = new VeiculoOcasiao ("Ocasiao" ,"Ocasiao","Ocasiao",2020, 130 , 80 , new ArrayList<>(),false);
        AutocarroInteligente autocarro = new AutocarroInteligente ("AutocarroInteligente" ,"AutocarroInteligente","AutocarroInteligente",2020, 130 , 80 , new ArrayList<>(),61);

        DriveIt stand = new DriveIt();

        stand.add(lambo);
        
        stand.add(ferrari);
        stand.add(ocasiao);
        stand.add(autocarro);

        
        
        
        
        
        stand.alteraPromocao(true);

        System.out.println ("Quantos Premium :  " + stand.quantosT("VeiculoPremium"));

        
    

/*         System.out.println ( "\n\nSET ORDENADO PELA MARCA: \n" + stand.ordenarVeiculos());
        System.out.println ( "\n\nLista ORDENADA PELA MARCA: \n" + stand.ordenarVeiculosLista());

        Comparator<Veiculo> comparatorKmDecrescente = (Comparator<Veiculo> & Serializable) (a1,a2) -> (int) (stand.getKms(a2.getIdentificacao()) - stand.getKms(a1.getIdentificacao()));
        Comparator<Veiculo> comparatorKMCrescente = (Comparator<Veiculo> & Serializable) (a1,a2) -> (int) (stand.getKms(a1.getIdentificacao()) - stand.getKms(a2.getIdentificacao()));
        Comparator<Veiculo> comparatorCustoCrescente = (Comparator<Veiculo> & Serializable) (a1,a2) -> (int) (stand.custoRealKm(a1.getIdentificacao()) - stand.custoRealKm(a2.getIdentificacao()));
        Comparator<Veiculo> comparadorDecrescente = (Comparator<Veiculo> & Serializable) (a1,a2) -> (int) (stand.custoRealKm(a2.getIdentificacao()) - stand.custoRealKm(a1.getIdentificacao()));

        System.out.println ( "\n\nSET ORDENADO CRESCENTE CUSTO: " + stand.ordenarVeiculos(comparatorCustoCrescente));
        System.out.println ( "\n\nSET ORDENADO DECRESCENTE KM: " + stand.ordenarVeiculos(comparatorKmDecrescente));
        stand.addComparador("COMPARADOR KMS2", comparatorKMCrescente);
        System.out.println ("\n\nADICIONADO O COMPARADOR KM2");
        System.out.println ( "\n\nSET ORDENADO DECRESCENTE KM2 ADICIONADO: " + stand.ordenarVeiculos("COMPARADOR KMS2"));

        Iterator <Veiculo> i = stand.ordenarVeiculo("COMPARADOR KMS2");
 
        while ( i .hasNext()){

            Veiculo v = i.next();
            System.out.println (v);
        } 
 
*/
        //FASE 4 TESTES
        DriveIt nova = new DriveIt();
    
        try {
            stand.gravaCSV("LogsGerados.csv");
        }
        catch (FileNotFoundException e){
            System.out.println("Ficheiro invalido!" + e.getMessage());
        }
        
        try{
            stand.gravaEmFicheiro("save.bin");
        }
        catch (IOException e){
            System.out.println("Ficheiro invalido!" + e.getMessage());
        }

        try {
            nova = stand.leFicheiro("save.bin");
        }
        catch (IOException e){
            System.out.println("Ooops nao consegui ler!" + e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println("Ooops nao consegui ler!" + e.getMessage());
        }


        
        
        System.out.println ( "\n\n\n\n\n\n\nLIDO DO BINARIO " + nova.toString());
        
    }
}
