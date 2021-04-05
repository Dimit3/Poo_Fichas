import java.util.List;


public class VeiculoPremium extends Veiculo implements BonificaKms
{

    private double taxaPremium;
    private int pontosPorKm;

    public VeiculoPremium() {
        super();
        this.taxaPremium = 1;
    }

    public VeiculoPremium (String identificacao, String marca, String modelo, int ano, double velocidadeMedia, double precoPorKm, List<Integer> avaliacoes, double taxaPremium){
        super(identificacao, marca, modelo, ano, velocidadeMedia, precoPorKm, avaliacoes);
        this.taxaPremium = taxaPremium;
    }

    public VeiculoPremium (VeiculoPremium ve){
        super(ve);
        this.taxaPremium = ve.gettaxaPremium();
    }

    public double gettaxaPremium() {
        return this.taxaPremium;
    }

    public void settaxaPremium(double taxaPremium) {
        this.taxaPremium = taxaPremium;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VeiculoPremium)) {
            return false;
        }
        VeiculoPremium v = (VeiculoPremium) o;
        return super.equals(v) && this.taxaPremium == v.gettaxaPremium();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
            .append("taxaPremium :").append(taxaPremium);

        return sb.toString();
    }

    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }


    public double custoRealKm(int kmsFeitos) {
        double r = kmsFeitos * this.getPrecoPorKm() * 1.1;
        return r * this.taxaPremium;
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