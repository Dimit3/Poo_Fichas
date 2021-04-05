import java.util.Comparator;


public class ComparatorEncDec implements Comparator<EncEficiente>{
    
    public int compare (EncEficiente e1, EncEficiente e2){
        Double valor1 = e1.calculaValorTotal();
        Double valor2 = e2.calculaValorTotal();
        return (int) (valor1.compareTo(valor2));
    }

}