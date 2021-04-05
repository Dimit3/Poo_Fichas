import java.util.List;


public class VeiculoOcasiao extends Veiculo{

    private boolean promocao;

    public VeiculoOcasiao() {
        super();
        this.promocao = false;
    }

    public VeiculoOcasiao (String identificacao, String marca, String modelo, int ano, double velocidadeMedia, double precoPorKm, List<Integer> avaliacoes, boolean promocao){
        super(identificacao, marca, modelo, ano, velocidadeMedia, precoPorKm, avaliacoes);
        this.promocao = promocao;
    }

    public VeiculoOcasiao (VeiculoOcasiao ve){
        super(ve);
        this.promocao = ve.getPromocao();
    }

    public boolean getPromocao() {
        return this.promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VeiculoOcasiao)) {
            return false;
        }
        VeiculoOcasiao v = (VeiculoOcasiao) o;
        return super.equals(v) && this.promocao == v.getPromocao();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
            .append("Promocao :").append(promocao);

        return sb.toString();
    }

    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }

    public double custoRealKm (int kmsFeitos){
        double r = kmsFeitos * this.getPrecoPorKm() * 1.1;
        if (this.promocao == true) r = r * 0.75f;
        return r;
        } 


}