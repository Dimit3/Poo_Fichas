import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;




public class EncEficiente {

    private String nome;
    private int nif;
    private String morada;
    private String numeroDaEncomenda;
    private LocalDate data;
    private ArrayList<Linhadeencomenda> linhas;


    //Constructors
    
    //by omission
    public EncEficiente () {
        this.nome = "NULL";
        this.nif  = 0;
        this.morada = "NULL";
        this.numeroDaEncomenda = "0000";
        this.data = LocalDate.now();
        this.linhas = new ArrayList<>(); //default size = 10
        
    }

    //by parameters
    public EncEficiente(String nome, int nif, String morada, String numeroDaEncomenda, LocalDate data, ArrayList<Linhadeencomenda> linhas) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numeroDaEncomenda = numeroDaEncomenda;
        this.data = data;
        this.linhas = linhas;
    }

    /**
     * by parameters without this.linhas, 
     * I like this constructor more, because this way we don't need to work with any ArrayLists in the main, 
     * We can just use this constructor and then directly add new Linhasdeencomenda with the 
     * public void adicionaLinha(LinhaEncomenda linha) method defined below
     * 
     */
    public EncEficiente(String nome, int nif, String morada, String numeroDaEncomenda, LocalDate data) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numeroDaEncomenda = numeroDaEncomenda;
        this.data = data;
        this.linhas = new ArrayList<>();
        }
    


    //by copy
    public EncEficiente(EncEficiente e){
        this.nome = e.getNome();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.numeroDaEncomenda = e.getNumeroDaEncomenda();
        this.data = e.getData();
        this.linhas = e.getLinhas();

    }


    //SETTERS AND GETTERS

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }


    public String getMorada() {
        return this.morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }


    public String getNumeroDaEncomenda() {
        return this.numeroDaEncomenda;
    }

    public void setNumeroDaEncomenda(String numeroDaEncomenda) {
        this.numeroDaEncomenda = numeroDaEncomenda;
    }


    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }



    
    //As we working with composition I implemented a deep copy in the getLinhas method

    public ArrayList<Linhadeencomenda> getLinhas() {
        ArrayList<Linhadeencomenda> ret = new ArrayList<Linhadeencomenda>();
    
        Iterator<Linhadeencomenda> it = this.linhas.iterator();        
        while(it.hasNext()){
            Linhadeencomenda now = it.next();
            ret.add(now.clone());
        }
  
        /**
         * another option 
         * 
        for (Linhadeencomenda l : this.linhas){
            ret.add(l.clone());
        }
        */

        return ret;
    }



    //clone method

    public EncEficiente clone () {
        return new EncEficiente(this);
    }


    /**
     * Equals method
     * 
     * the for loop tests if every element in this.linhas is equal to e.linhas elements
     * on the return it tests if all the parameters in encomenda are equal, as well as the result 
     * of the for loop before if everything is true, the return value will be true
     * 
     * Very subjective answer, we could only consider equal if they have the same products or same order number
     * 
     * @param e
     * @return true if everything is equal
     */

    public boolean equals(EncEficiente e) {
        if (e == this)
            return true;
        if (!(e instanceof EncEficiente)) {
            return false;
        }

        int i = 0;
        Boolean x = true;

        if (this.linhas.size() != e.getSize())
            return false;
    
        for (i = 0; i < this.linhas.size(); i++)
            if((this.linhas.get(i).equals(e.linhas.get(i))) != true )
                x = false;


        return x && this.nome.equals(e.getNome()) && this.nif == e.getNif() 
        && this.morada.equals(e.getMorada()) && this.data.equals(e.getData())
        && this.numeroDaEncomenda.equals(e.getNumeroDaEncomenda());
    }



    public String toString (){
        
        String itens ="";
        Iterator<Linhadeencomenda> it = this.linhas.iterator();
        Linhadeencomenda now;

        while(it.hasNext()){
            now = it.next();
            {
                itens = itens + now.toString();
                itens = itens + "\n";
            }
        }
            
        String out = "";
        out = "\nNome de cliente: " + this.nome 
        + "\nNIF: " + this.nif
        + "\nMorada: " + this.morada
        + "\nNumero de Encomenda: " + this.numeroDaEncomenda
        + "\nData da Encomenda: " + this.data
        + "\nItens: \n" + itens;

        return out;
        }


    //getSize of Arraylist
    public int getSize(){
        return this.linhas.size();
    }
    

    //B
    public double calculaValorTotal(){
        Double total = (double) 0;
        Iterator<Linhadeencomenda> it = this.linhas.iterator();

        for (; it.hasNext();){
            Linhadeencomenda e = it.next();
            total = total  + e.calculaValorLinhaEnc();
        }

        return total;
    }



    //C
    public double calculaValorDesconto() {
        Double total = (double) 0;
        Iterator<Linhadeencomenda> it = this.linhas.iterator();
    
        while(it.hasNext()){
            Linhadeencomenda e = it.next();
            total = total + e.calculaValorDesconto();
        }
    
        return total;
    }


    //D
    public int numeroTotalProdutos(){
        int quantidade = 0;
        Iterator<Linhadeencomenda> it = this.linhas.iterator();

        while(it.hasNext()){
            Linhadeencomenda e = it.next();
            quantidade = quantidade + e.getQuantidade();
        }

        return quantidade;
    }


    //E
    public boolean existeProdutoEncomenda(String refProduto){

        Iterator<Linhadeencomenda> it = this.linhas.iterator();

        while(it.hasNext()){
            Linhadeencomenda now = it.next();
            if(now.getReferencia().equals(refProduto))
                return true;
        }

        return false;
    }


    //F

    public void adicionaLinha(Linhadeencomenda linha){
        linhas.add(linha);
    }

    //G

    public void removeProduto(String codProd){
        Iterator<Linhadeencomenda> it = this.linhas.iterator();

        while(it.hasNext()){
            Linhadeencomenda now = it.next();
            if(now.getReferencia().equals(codProd))
                it.remove();
        }


    }





}






