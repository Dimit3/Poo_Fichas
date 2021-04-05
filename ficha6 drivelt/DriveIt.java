import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * A classe DriveIt, eu sugiro implementar como um Map<String, Veiculo> em que
 * String é a matrícula. Isto porque vários dos exercícios referem-se ao veiculo
 * pela matrícula
 */


 /* Para a alínea h), De facto, não mencionamos no enunciado como guardar essa info. 
    Pode-se guardar isso numa coleção (p.e. um map <String, Integer>   (matricula, kms) )
    no DriveIt, ou podes optar por colocar essa informação no Veículo, 
    como variável de instância. Como não indicamos 
    explicitamente como o fazer no enunciado, deixo ao vosso critério.  */



public class DriveIt implements Serializable {

    private Map<String, Veiculo> veiculos;
    private Map<String, Integer> kmsFeitos;
    private Map<String, Comparator<Veiculo>> comparadores;
    

    public DriveIt() {
        veiculos = new HashMap<>();
        kmsFeitos = new HashMap<>();
        comparadores = new HashMap<>();
    }

    public DriveIt(Map<String,Veiculo> Veiculos,Map<String, Integer> kmsFeitos ) {
        setVeiculosMap(veiculos);
        setKmsFeitos(kmsFeitos);
        comparadores = new HashMap<>();
    }

    public DriveIt(DriveIt e) {
        setVeiculosMap(e.getVeiculosMap());
        setKmsFeitos(e.getKmsFeitos());
        comparadores = new HashMap<>();
    }


    public Map<String,Veiculo> getVeiculosMap() {
        Map <String, Veiculo> ret = new HashMap<>();
        this.veiculos.entrySet().forEach(v -> ret.put(v.getKey(), v.getValue().clone()));
        return ret;
    }

    public void setVeiculosMap(Map<String,Veiculo> Veiculos) {
        this.veiculos = new HashMap<>();
        Veiculos.entrySet().forEach(v -> this.veiculos.put(v.getKey(),v.getValue().clone()));
    }

    public Map<String, Integer> getKmsFeitos (){
        Map<String, Integer> ret = new HashMap<>();
        this.kmsFeitos.entrySet().forEach(v -> ret.put(v.getKey(), v.getValue()));
        return ret;
    }
    public void setKmsFeitos(Map<String, Integer> kmsFeitos){
        this.kmsFeitos = new HashMap<>();
        kmsFeitos.entrySet().forEach(v -> this.kmsFeitos.put(v.getKey(), v.getValue()));
    }
    public int getKms (String cod){
        return kmsFeitos.get(cod);
    }

    public boolean equals (Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DriveIt)) {
            return false;
        }
        DriveIt d = (DriveIt) o;
        return d.getVeiculosMap().equals(this.veiculos) && 
                d.getKmsFeitos().equals(this.kmsFeitos);
    }


    public DriveIt clone (){
        return new DriveIt(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nVEICULOS\n").append(veiculos.toString());
        sb.append("\nKMS FEITOS\n").append(kmsFeitos.toString());
        return sb.toString();
    }


    //a

    public boolean existeVeiculo(String cod){
        return veiculos.containsKey(cod);
    }

    //b

    public int quantos() {
        return veiculos.size();
    }

    //c
    public int quantos(String marca){
        return (int) veiculos
                    .values()
                    .stream()
                    .filter(v -> v.getMarca().equals(marca))
                    .count();
    }

    //d

    public Veiculo getVeiculo(String cod) throws VeiculoNaoExistenteException{
        if (!(veiculos.containsKey(cod))) throw new VeiculoNaoExistenteException("Veiculo com codigo " + cod + " nao existente");
        return veiculos.get(cod);
    }

    //e

    public void add (Veiculo v) throws VeiculoRepetidoException {
        if ((veiculos.containsKey(v.getIdentificacao()))) throw new VeiculoRepetidoException("Veiculo " + v.getIdentificacao() + " ja existente");
        veiculos.put(v.getIdentificacao(), v.clone());
    }

    //f
    public List<Veiculo> getVeiculos() {
        return this.veiculos.values().stream().map(x -> x.clone()).collect(Collectors.toCollection(ArrayList::new));
    }

    //g
    public void adiciona(Set<Veiculo> vs) throws VeiculoRepetidoException {
        for (Veiculo v : vs){
            this.add(v);
        }
    }

    //h

    public void registarAluguer(String codVeiculo, int numKms) throws ValorInvalidoException, VeiculoNaoExistenteException{
        if (numKms < 0) throw new ValorInvalidoException("Valor de kms nao pode ser menor que 0");
        if (!kmsFeitos.containsKey(codVeiculo)) throw new VeiculoNaoExistenteException("Veiculo nao existente");

        int ant = kmsFeitos.get(codVeiculo);
        numKms = ant + numKms;
        kmsFeitos.put(codVeiculo, numKms);

    }

    //i
    public void classificarVeiculo(String cod, int classificacao) throws ValorInvalidoException
    {
        if (classificacao < 0) throw new ValorInvalidoException("Erro, a classificacao nao pode ser inferior a 0");
        this.veiculos.get(cod).addAvaliacao(classificacao);
    }

    //j 


    public int custoRealKm(String cod) {
        double r = 0;
        Veiculo v = this.veiculos.get(cod);
        if (v != null) {
            r = v.custoRealKm(kmsFeitos.get(cod));
        }
        return (int) r;
    }


    //3
    
    //c
    public int quantosT(String tipo){
        return (int) this.veiculos.values().stream().filter(x -> x.getClass().getName().equals(tipo)).count();
    }


    //g
    private Comparator<Veiculo> comparadorDecrescente = (Comparator<Veiculo> & Serializable) (a1,a2) -> (int) (a2.custoRealKm(kmsFeitos.get(a2.getIdentificacao())) - (a1.custoRealKm(kmsFeitos.get(a1.getIdentificacao()))));

    public List<Veiculo> veiculosOrdenadosCusto() {
        List<Veiculo> ret = new ArrayList<>();
        for (Veiculo v : veiculos.values()){
            ret.add(v.clone());
        }
        ret.sort(comparadorDecrescente);
        return ret;
    }
 
    //h
     public Veiculo veiculoMaisBarato(){
        List<Veiculo> v = this.veiculosOrdenadosCusto();
        int ultimo = v.size() - 1;
        return v.get(ultimo);
    }

    //I
    public Veiculo veiculoMenosUtilizado(){
        double min = Double.POSITIVE_INFINITY;;
        String cod = "";
        String minCod = "";

        Iterator<String> it = kmsFeitos.keySet().iterator();
        while(it.hasNext()){
            cod = it.next();
            if (kmsFeitos.get(cod) < min){
                min = kmsFeitos.get(cod);
                minCod = cod;
            }
        }

        return veiculos.get(minCod);
    }

    //n
    public void alteraPromocao(boolean estado){
        for (Veiculo v: veiculos.values()){
            if (v.getClass().getName().equals("VeiculoOcasiao")){
                VeiculoOcasiao vo = (VeiculoOcasiao) v;
                vo.setPromocao(estado);
            }
        }
    }

    //11
    public double mediaKmAutocarros (){
        List<AutocarroInteligente> bus = new ArrayList<>();
        for (Veiculo v: veiculos.values()){
            if (v.getClass().getName().equals("AutocarroInteligente")){
                bus.add((AutocarroInteligente) v.clone());
            }
        }
        
        double soma = 0.0;
        int size = bus.size();

        for (AutocarroInteligente a : bus) {
            a.setOcupacao(0.85);
            soma += a.custoRealKm(kmsFeitos.get(a.getIdentificacao()));
        }   
    
        return (soma/size) * 0.25;
    }



//FASE 2

//2 

//a)

public Set<Veiculo> ordenarVeiculos() {
    Set<Veiculo> ret = new TreeSet<>();

    for (Veiculo x : veiculos.values()){
        ret.add(x.clone());
    }

    return ret;
} 


//b

public List<Veiculo> ordenarVeiculosLista() {
    List<Veiculo> ret = new ArrayList<>();

    for (Veiculo x : veiculos.values()){
        ret.add(x.clone());
    }
    ret.sort(null);
    return ret;
}


//c

public Set<Veiculo> ordenarVeiculos(Comparator<Veiculo> c){
    Set<Veiculo> ret = new TreeSet<>(c);

    for (Veiculo x : veiculos.values()){
        ret.add(x.clone());
    }

    return ret;
}

//d
public void addComparador (String comparador , Comparator<Veiculo> c){
    comparadores.put(comparador, c);
}

public List<Veiculo> ordenarVeiculos (String comparador){

    List<Veiculo> ret = new ArrayList<>();

    for (Veiculo x : veiculos.values()){
        ret.add(x.clone());
    }
    ret.sort(comparadores.get(comparador));
    return ret;
}
//e
public Iterator<Veiculo> ordenarVeiculo(String criterio){
    List<Veiculo> ret = new ArrayList<>();

    for (Veiculo x : veiculos.values()){
        ret.add(x.clone());
    }
    if (comparadores.get(criterio) != null){
        ret.sort(comparadores.get(criterio));
    }

    Iterator<Veiculo> it = ret.iterator();
    return it;
}




//fase 3


//como eu fiz map de identificação para kms assim faço set de todos os kms nos objetos veiculos
public void setTodosKms () {
    for (String id : kmsFeitos.keySet()){
        veiculos.get(id).setKms(kmsFeitos.get(id));
    }
}


public List<BonificaKms> daoPontos() {
    List<BonificaKms> ret = new ArrayList<>();
    for (Veiculo v: veiculos.values()){
        if(v instanceof BonificaKms){
            ret.add((BonificaKms)v);
        }
    }
    return ret;
}

//FASE 4

    //csv

    public void gravaCSV (String nomeFicheiro) throws FileNotFoundException{
        
        PrintWriter pw = new PrintWriter(nomeFicheiro);

        pw.println("Carros:\n");
        for (Veiculo v: this.veiculos.values()){
            pw.println(v.toStringCSV()); //Devolve linha csv
        }
        pw.flush();
        pw.close();
        
        
        
        
    }

    public void gravaEmFicheiro (String nomeFicheiro) throws IOException  {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
        fos.close();
    }


    public DriveIt leFicheiro (String nomeFicheiro) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        DriveIt r = (DriveIt) ois.readObject();
        ois.close();
        fis.close();
        return r;
    }

}