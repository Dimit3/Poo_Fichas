import java.time.LocalDate;




public class Encomenda {

/*  nome do cliente
 número fiscal do cliente
 morada do cliente
 número da encomenda
 data da encomenda
 as linhas da encomenda (nesta fase guardadas num array) */

 private String nome;
 private int nif;
 private String morada;
 private int numeroDaEncomenda;
 private LocalDate data;
 private Linhadeencomenda [] linhas;
 
//  private int pos, tamanho -> para depois fazer crescer array

//contrutores 

public Encomenda () {
    this.nome = "NULL";
    this.nif  = 0;
    this.morada = "NULL";
    this.numeroDaEncomenda = 0;
    this.data = LocalDate.now();
    this.linhas = new Linhadeencomenda[4];
}

public Encomenda (Encomenda e) {
    this.nome = e.getNome();
    this.nif = e.getNif();
    this.morada = e.getMorada();
    this.numeroDaEncomenda = e.getNumeroDaEncomenda();
    this.data = e.getData();
    
    this.linhas = new Linhadeencomenda[4];
    this.linhas = e.getLinha();   
}

public Encomenda (String nome, int nif, String m, int numero, LocalDate data, Linhadeencomenda[] l){
    this.nome = nome;
    this.nif = nif;
    this.morada = m;
    this.numeroDaEncomenda = numero;
    this.data = data;
    this.linhas = l;
}


//clone toString equals

public Encomenda clone (){
    return new Encomenda(this);
}

public String toString (){
    
    String itens ="";
    for (int i = 0; i < this.linhas.length; i++){
        if (linhas[i] != null){
            itens = itens + linhas[i].toString();
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



public Boolean equals (Encomenda e){
    Boolean x = true;
    int i = 0;
    for (i = 0; i < this.linhas.length; i++){
        if (this.linhas[i].equals(e.getlinhan(i)) != true)
            x = false;
    }
    return x;
}



//Getters 
public String getNome () {
    return this.nome;
}

public int getNif (){
    return this.nif;
}

public String getMorada () {
    return this.morada;
}

public int getNumeroDaEncomenda () {
    return this.numeroDaEncomenda;
}

public LocalDate getData () {
    return this.data;
}

/**
 * 
 * @return linha de encomenda n
 */
public Linhadeencomenda getlinhan(int n){
    return this.linhas[n].clone();
}

/**
 * 
 * @return todas as linhas de encomenda
 */
public Linhadeencomenda[] getLinha (){
    return this.linhas.clone();
}



//Setters 

public void setNome (String n){
    this.nome = n;
}

public void setNif (int nif){
    this.nif = nif;
}  

public void setMorada (String m){
    this.morada = m;
}

public void setNumeroDaEncomenda (int numero){
    this.numeroDaEncomenda = numero;
}

public void setData (LocalDate data){
    this.data = data;
}

//muda a linha de encomenda com indice n para l
public void setLinhaDeEncomendan (Linhadeencomenda l,int n){
    this.linhas[n] = l;
}

//muda todo o array de linha de encomendas
public void setLinhaDeEncomenda (Linhadeencomenda[] l){
    this.linhas = l;
}



//8b

public double calculaValorTotal(){
    Double total = (double) 0;
    int i;

    for (i=0; i < this.linhas.length; i++){
        total = this.linhas[i].calculaValorLinhaEnc();
    }

    return total;
}



}