
import java.util.*;


public class VeiculoNormal extends Veiculo
{
   public VeiculoNormal(){
    super();
    }
   
   public VeiculoNormal(String identificacao, String marca, String modelo, int ano, double velocidadeMedia, double precoPorKm, List<Integer> avaliacoes){
    super(identificacao, marca, modelo, ano, velocidadeMedia, precoPorKm, avaliacoes);
    } 
   
   public VeiculoNormal(VeiculoNormal v){
    super(v);
    } 
   
   public boolean equals(Object o){
   if (o == this) return true;
   if (o == null || o.getClass() != this.getClass()) return false;
   VeiculoNormal v = (VeiculoNormal) o;
   
   return super.equals(v);
    }
   
   public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    return sb.toString();
    } 
    
   public VeiculoNormal clone(){
    return new VeiculoNormal(this);
    } 

    
   public double custoRealKm(int kms){
    double r = kms * this.getPrecoPorKm() * 1.1;
    return r;
    } 
}
