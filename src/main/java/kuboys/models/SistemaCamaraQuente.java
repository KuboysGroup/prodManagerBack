package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
public class SistemaCamaraQuente extends Produto{
    @JsonProperty("materialResistencia")
    private Material materialResistencia;
    @JsonProperty("tempOperacao")
    private double tempOperacao;

    public SistemaCamaraQuente() {
    }

    public SistemaCamaraQuente(String nome, Dimensoes dimensoes, boolean tratamentoTermico, int quantidade, Material materialResistencia, double tempOperacao) {
        super(nome, dimensoes, tratamentoTermico, quantidade);
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
