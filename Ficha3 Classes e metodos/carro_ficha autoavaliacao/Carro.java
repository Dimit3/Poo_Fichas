public class Carro {

    private String marca;
    private String modelo;
    private int ano;
    private Double consumo;    //consumo por km a 100km/h
    private Double kmsTotal;        //kmsTotal do carro
    private Double mediaTotal;     //media consumo total desde o inicio
    private Double kmsUltimo;       //kms ultima viagem
    private Double mediaUltima;    //ultima media de consumo
    private Double abateAoConsumo;  //quando se trava durante 1km
   
    private Boolean estado;       //true -> ligado    false-> desligado

    //construtor vazio
    public Carro() {
        this.marca = "NULL";
        this.modelo = "NULL";
        this.ano = 0;
        this.consumo = (double) 0;
        this.kmsTotal = (double) 0;
        this.mediaTotal = (double) 0;
        this.kmsUltimo = (double) 0;
        this.mediaUltima =  (double) 0;
        this.abateAoConsumo =  (double) 0;
        this.estado = false;

    }

    public Carro(String marca, String modelo, int ano, Double consumo, Double kmsTotal, Double mediaTotal, Double kmsUltimo, Double mediaUltima, Double abateAoConsumo, Boolean estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.consumo = consumo;
        this.kmsTotal = kmsTotal;
        this.mediaTotal = mediaTotal;
        this.kmsUltimo = kmsUltimo;
        this.mediaUltima = mediaUltima;
        this.abateAoConsumo = abateAoConsumo;
        this.estado = estado;
    }
    

    //construtor por copia

    public Carro (Carro c){
        this.marca = c.getMarca();
        this.modelo = c.getModelo();
        this.ano = c.getAno();
        this.consumo = c.getConsumo();
        this.kmsTotal = c.getkmsTotal();
        this.mediaTotal = c.getMediaTotal();
        this.kmsUltimo = c.getkmsUltimo();
        this.mediaUltima = c.getMediaUltima();
        this.abateAoConsumo = c.getAbateAoConsumo();
        this.estado = c.getEstado();
    }




    //getters e setters 
    
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public Double getConsumo() {
        return this.consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }


    public Double getkmsTotal() {
        return this.kmsTotal;
    }

    public void setkmsTotal(Double kmsTotal) {
        this.kmsTotal = kmsTotal;
    }


    public Double getMediaTotal() {
        return this.mediaTotal;
    }

    public void setMediaTotal(Double mediaTotal) {
        this.mediaTotal = mediaTotal;
    }


    public Double getkmsUltimo (){
        return this.kmsUltimo;
    }

    public void setkmsUltimo(Double k){
        this.kmsUltimo = k;
    }

    public Double getMediaUltima() {
        return this.mediaUltima;
    }

    public void setMediaUltima(Double mediaUltima) {
        this.mediaUltima = mediaUltima;
    }


    public Double getAbateAoConsumo() {
        return this.abateAoConsumo;
    }

    public void setAbateAoConsumo(Double abateAoConsumo) {
        this.abateAoConsumo = abateAoConsumo;
    }

    public Boolean getEstado(){
        return this.estado;
    }

    public void setEstado (Boolean e){
        this.estado = e;
    }


    public String toString() {
        return "{" +
            " marca='" + getMarca() + "'" +
            ", modelo='" + getModelo() + "'" +
            ", ano='" + getAno() + "'" +
            ", consumo='" + getConsumo() + "'" +
            ", kmsTotal='" + getkmsTotal() + "'" +
            ", mediaTotal='" + getMediaTotal() + "'" +
            ", kmsUltima='"  + getkmsUltimo() + "" +
            ", mediaUltima='" + getMediaUltima() + "'" +
            ", abateAoConsumo='" + getAbateAoConsumo() + "'" +
            ", estado='" + getEstado() + "''" +
            "}";
    }


    public Carro clone (){
        return new Carro (this);
    }
   

    public boolean equals(Carro o) {
        if (o == this)
            return true;
        if (!(o instanceof Carro)) {
            return false;
        }
        Carro carro = (Carro) o;
        return marca.equals(carro.marca) && modelo.equals(carro.modelo) && ano == carro.ano;
    }

    
    //6b

    public void ligaCarro(){
        this.estado = true;
        //reset
        this.mediaUltima = (double) 0;
    }


    //6c

    public void desligaCarro(){
        this.estado = false;
    }


    //6d

    public void resetUltimaViagem(){
        this.mediaUltima = (double) 0;
    }

    //6e

    public void avancaCarro(double metros, double velocidade){

        if (estado == true) 
        {
        Double kms = metros /1000;

        this.mediaTotal = (this.mediaTotal * this.kmsTotal + this.consumo * kms)/(this.kmsTotal + kms);
        this.kmsTotal = this.kmsTotal + kms;

        this.mediaUltima = (this.mediaUltima * this.kmsUltimo + this.consumo * kms)/(this.kmsUltimo + kms);
        this.kmsUltimo = this.kmsUltimo + kms;
        }


    }


    //6f

    public void travaCarro(double metros){

        if (estado == true)  
        {
        Double ac;
        ac = this.abateAoConsumo * (metros/1000);

        this.mediaTotal = this.mediaTotal -ac;
        this.mediaUltima = this.mediaUltima - ac;
        }
    }

}