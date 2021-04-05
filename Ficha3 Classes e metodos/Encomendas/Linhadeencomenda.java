public class Linhadeencomenda {
    
    //7a cenas basicas 
    
    private String referencia;      //referencia do produto (codigo dele)
    private String discricao;       
    private Double precoSemImposto;    //preço antes de impostos aplicados
    private int quantidade;         //numero de artigos
    private int imposto;            //valor em percentagem de desconto
    private int desconto;           //valor em percentagem do desconto comercial em relaçao ao preço antes dos impostos



    //Construtores

    
    public Linhadeencomenda (){
        this.referencia = "NULL";
        this.discricao  = "NULL";
        this.precoSemImposto = (double)0;
        this.quantidade      = 0;
        this.imposto         = 0;
        this.desconto        = 0;
    }

    public Linhadeencomenda (String ref, String discricao, Double preco, int quantidade, int imposto, int desconto){
        this.referencia = ref;
        this.discricao = discricao;
        this.precoSemImposto = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    public Linhadeencomenda (Linhadeencomenda l){
        this.referencia = l.getReferencia();
        this.discricao  = l.getDescricao(); 
        this.precoSemImposto = l.getPrecoSemImposto();
        this.quantidade = l.getQuantidade();
        this.imposto = l.getImposto();
        this.desconto = l.getDesconto();   
    }

    //Clone

    public Linhadeencomenda clone (){
        return new Linhadeencomenda(this);
    }

    /**Equals
     * tests if 2 products have the same id
     * @Boolean
     */
    
    public Boolean equals (Linhadeencomenda l){
        return this.referencia.equals(l.getReferencia());
    }

    //toString

    public String toString (){
        return "\nReferencia: " + this.referencia 
        + "\nDescricao: " + this.discricao 
        + "\nprecoSemImposto " + this.precoSemImposto +"$"
        + "\nquantidade " + this.quantidade 
        + "\nimposto " + this.imposto + "%"
        + "\ndesconto " + this.desconto + "%";
    }

    //Getters

    public String getReferencia () {
        return this.referencia;
    }

    public String getDescricao () {
        return this.discricao;
    }

    public Double getPrecoSemImposto () {
        return this.precoSemImposto;
    }

    public int getQuantidade () {
        return this.quantidade;
    }

    public int getImposto () {
        return this.imposto;
    }

    public int getDesconto () {
        return this.desconto;
    }


    //Setters

    public void setReferencia (String ref) {
        this.referencia = ref;
    }

    public void setDescricao (String disc) {
        this.discricao = disc;
    }

    public void setPrecoSemImposto (Double p){
        this.precoSemImposto = p;
    }

    public void setQuantidade (int q){
        this.quantidade = q;
    }

    public void setImposto (int i){
        this.imposto = i;
    }

    public void setDesconco (int d) {
        this.desconto = d;
    }
    


    //7b 

    public double calculaValorLinhaEnc() {

        double precoUnitCdesconto = this.precoSemImposto * (100-this.desconto)/100;
        double precoFinal = precoUnitCdesconto * (this.imposto + 100)/100;
        return this.quantidade * precoFinal;
    }

    //7c

    public double calculaValorDesconto() {
        Double inic = (this.quantidade * this.precoSemImposto);
        Double desc = inic - (inic * (1-(this.desconto)/100));
        return desc;
    }



}