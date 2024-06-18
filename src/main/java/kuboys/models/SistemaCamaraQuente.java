package kuboys.models;

public class SistemaCamaraQuente extends Produto{

    private Material materialResistencia;
    private double tempOperacao;

    public SistemaCamaraQuente() {
        super();
        this.materialResistencia = new Material();
        this.tempOperacao = 0.0;
    }

    public SistemaCamaraQuente(String nome, Dimensoes dimensoes, boolean tratamentoTermico, Material materialResistencia, double tempOperacao) {
        super(nome, dimensoes, tratamentoTermico);
        this.materialResistencia = materialResistencia;
        this.tempOperacao = tempOperacao;
    }

    public Material getMaterialResistencia() {
        return materialResistencia;
    }

    public void setMaterialResistencia(Material materialResistencia) {
        this.materialResistencia = materialResistencia;
    }

    public double getTempOperacao() {
        return tempOperacao;
    }

    public void setTempOperacao(double tempOperacao) {
        this.tempOperacao = tempOperacao;
    }
}
