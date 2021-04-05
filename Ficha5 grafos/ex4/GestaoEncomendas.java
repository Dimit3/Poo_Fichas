import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;

public class GestaoEncomendas {

    private Map<String,EncEficiente> encomendas;


    //construtores
    public GestaoEncomendas() {
        this.encomendas = new HashMap<>();
    }

    public GestaoEncomendas(Map<String,EncEficiente> enc) {
        setEncomendas(enc);
    }

    public GestaoEncomendas(GestaoEncomendas enc) {
        setEncomendas(enc.getEncomendas());
    }


    //get
    public Map<String,EncEficiente> getEncomendas() {
        Map <String, EncEficiente> ret = new HashMap<>();
        for (Map.Entry<String, EncEficiente> e : this.encomendas.entrySet()){
            ret.put(e.getKey(), e.getValue().clone());
        }
        return ret;
    }


    //set
    public void setEncomendas(Map<String,EncEficiente> enc) {
        this.encomendas = new HashMap<>();
        enc.entrySet().forEach(e -> this.encomendas.put(e.getKey(), e.getValue().clone()));
    }


    //tostring
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomendas: \n").append(this.encomendas);
        return sb.toString();
    }

    //equals
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        GestaoEncomendas g = (GestaoEncomendas) o;
        return g.getEncomendas().equals(this.encomendas);
    }


    //clone
    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }


    //i
    public Set<String> todosCodigosEnc(){
        Set<String> s = new TreeSet<String>();
        for (String codigo : this.encomendas.keySet()){
            s.add(codigo);
        }
        return s;
        //return new TreeSet<>(this.encomendas.keySet())
    } 

    //ii
    public void addEncomenda(EncEficiente enc){
        this.encomendas.put(enc.getNumeroDaEncomenda(), enc.clone());
    }

    //iii
    public EncEficiente getEncomenda(String codEnc){
        return this.encomendas.get(codEnc).clone();
    }


    //iv
    public void removeEncomenda(String codEnc){
        this.encomendas.remove(codEnc);
    }

    //v
    public String encomendaComMaisProdutos(){
        String code = "Null";
        int max = 0;

        for (EncEficiente e: this.encomendas.values()){
            if ((e.numeroTotalProdutos()) > max){
                max = e.numeroTotalProdutos();
                code = e.getNumeroDaEncomenda();
            }
        }
                     
        return code;
    }


    //vi
    public Set<String> encomendasComProduto(String codProd){
        Set<String> ret = new HashSet<>();

        for (EncEficiente e: this.encomendas.values()){
            if (e.existeProdutoEncomenda(codProd)){
                ret.add(e.getNumeroDaEncomenda());
            }
        }

        return ret;
    }

    //vii
    public Set<String> encomendasAposData(LocalDate d){
        Set<String> ret = new TreeSet<>();

        for (EncEficiente e: this.encomendas.values()){
            if (e.getData().isAfter(d)){
                ret.add(e.getNumeroDaEncomenda());
            }
        }

        return ret;
    }



    //viii
    public Set<EncEficiente> encomendasValorDecrescente(){
        Set<EncEficiente> ret = new TreeSet<>(new ComparatorEncDec());
        for (EncEficiente e: this.encomendas.values()){
            ret.add(e.clone());
        }
        return ret;
    }


    //ix
    public Map<String,List<String>> encomendasDeProduto(){
        Map<String,List<String>> ret = new HashMap<>() ;
        Set<String> keys = new HashSet<>();


        for (EncEficiente e: this.encomendas.values()){
            for (Linhadeencomenda l: e.getLinhas()){
                keys.add(l.getReferencia());
            }
        }

        for (String s: keys){
            List<String> l = new ArrayList<>();
            for (EncEficiente e: this.encomendas.values()){
                if (e.existeProdutoEncomenda(s)){
                    l.add(e.getNumeroDaEncomenda());
                }
            }

            ret.put(s, l);
        }
        return ret;
    }




}   