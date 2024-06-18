package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SistemaCamaraQuente extends Produto{
    private static final long serialVersionUID = 1872448921919223045L;
    @JsonProperty("materialResistencia")
    private Material materialResistencia;
    @JsonProperty("tempOperacao")
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
