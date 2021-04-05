import java.util.*;


public class AutocarroInteligente extends Veiculo implements BonificaKms
{
    private double ocupacao;
    private int pontosPorKm;
   
    public AutocarroInteligente(){
    super();
    this.ocupacao = 0.0;
    }
   
   public AutocarroInteligente(String identificacao, String marca, String modelo, int ano, double velocidadeMedia, double precoPorKm, List<Integer> avaliacoes, double o){
    super(identificacao, marca, modelo, ano, velocidadeMedia, precoPorKm, avaliacoes);
    this.ocupacao = o;
    } 
   
   public AutocarroInteligente(AutocarroInteligente v){
    super(v);
    this.ocupacao = v.getOcupacao();
    } 
   
   public double getOcupacao(){
   return this.ocupacao; 
    } 
   public void setOcupacao(double o){
   this.ocupacao = o; 
    }
    
   public boolean equals(Object o){
   if (o == this) return true;
   if (o == null || o.getClass() != this.getClass()) return false;
   AutocarroInteligente v = (AutocarroInteligente) o;
   
   return super.equals(v) && this.ocupacao == v.getOcupacao();
    }
   
   public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString())
    .append("Ocupacao:").append(ocupacao);
    return sb.toString();
    } 
    
   public AutocarroInteligente clone(){
    return new AutocarroInteligente(this);
    } 


   public double custoRealKm(int kmsFeitos) {
        double r = kmsFeitos * this.getPrecoPorKm() * 1.1;
        if (this.ocupacao < 61.0) return r*0.5;
        else return r*0.75;
        
    }

    public void setPontosPorKm (int p){
        this.pontosPorKm = p;
    }

    public int getPontosPorKm() {
        return this.pontosPorKm;
    }

    public int getPontos (){
        return this.pontosPorKm * super.getKms();
    }

}
