import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo implements Comparable<Veiculo>, Serializable {

    private String identificacao;
    private String marca;
    private String modelo;
    private int ano;
    private double velocidadeMedia;
    private double precoPorKm;
    private List<Integer> avaliacoes;
    private int Kms;

    //CONSTRUTORES
    public Veiculo() {
        this.identificacao = "Null";
        this.marca = "Null";
        this.modelo = "Null";
        this.ano = 0;
        this.velocidadeMedia = 0.0;
        this.precoPorKm = 0.0;
        this.avaliacoes = new ArrayList<>();
    }

    public Veiculo(String identificacao, String marca, String modelo, int ano, double velocidadeMedia, double precoPorKm, List<Integer> avaliacoes) {
        this.identificacao = identificacao;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeMedia = velocidadeMedia;
        this.precoPorKm = precoPorKm;
        this.avaliacoes = new ArrayList<>(avaliacoes);
    }

    public Veiculo (Veiculo v){
        this.identificacao = v.getIdentificacao();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.ano = v.getAno();
        this.velocidadeMedia = v.getVelocidadeMedia();
        this.precoPorKm = v.getPrecoPorKm();
        this.avaliacoes = v.getAvaliacoes();
    }


    //SET E GET
    public String getIdentificacao() {
        return this.identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

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

    public double getVelocidadeMedia() {
        return this.velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public double getPrecoPorKm() {
        return this.precoPorKm;
    }

    public void setPrecoPorKm(double precoPorKm) {
        this.precoPorKm = precoPorKm;
    }

    public List<Integer> getAvaliacoes() {
        return new ArrayList<>(avaliacoes);
    }

    public void setAvaliacoes(List<Integer> avaliacoes) {
        this.avaliacoes = new ArrayList<>(avaliacoes);
    }

    public int getKms () {
        return this.Kms;
    }

    public void setKms (int kms) {
        this.Kms = kms;
    }

    //equals
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Veiculo)) {
            return false;
        }
        Veiculo v = (Veiculo) o;
        return identificacao == v.getIdentificacao();
    }

    //clone
    public abstract Veiculo clone ();
    
    
    //tostring
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\n{ identificacao = ").append(getIdentificacao())
        .append("\nmarca = ").append(getMarca())
        .append("\nmodelo = ").append(getModelo())
        .append("\nano = ").append(getAno())
        .append("\nvelocidadeMedia = ").append(getVelocidadeMedia())
        .append("\npreco por km = ").append(getPrecoPorKm())
        .append("\navaliacoes = ").append(getAvaliacoes())
        .append("\nkms = ").append(this.Kms).append(" }");
        return sb.toString();
    }

    public void addAvaliacao (int n) {
        avaliacoes.add(n);
    }


    public abstract double custoRealKm (int kmsFeitos);

    //alfabetica
    public int compareTo (Veiculo v){
        if (this.getMarca().equals(v.getMarca()))
            return this.modelo.compareTo(v.getModelo());
        else 
            return this.marca.compareTo(v.getMarca());
    } 


    public String toStringCSV () {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getIdentificacao()).append(":")
        .append(getMarca())
        .append(",").append(getModelo())
        .append(",").append(getAno())
        .append(",").append(getVelocidadeMedia())
        .append(",").append(getPrecoPorKm())
        .append(",").append(this.Kms);
        
        for (int i: this.avaliacoes){
            sb.append(i).append(",");
        }
        
     
        return sb.toString();
    }

    

}