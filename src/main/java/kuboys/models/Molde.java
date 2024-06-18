package kuboys.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kuboys.enums.EnumRamoProduto;
import kuboys.enums.EnumTipoInjecao;

import java.util.ArrayList;
import java.util.List;

public class Molde extends Produto{
    @JsonProperty("tipoInjecao")
    private EnumTipoInjecao tipoInjecao;
    @JsonProperty("ramoMolde")
    private EnumRamoProduto ramoMolde;
    @JsonProperty("componentes")
    private List<Componente> componentes;

    public Molde() {
    }

    public Molde(String nome, Dimensoes dimensoes, boolean tratamentoTermico, EnumTipoInjecao tipoInjecao, EnumRamoProduto ramoMolde, List<Componente> componentes) {
        super(nome, dimensoes, tratamentoTermico);
        this.tipoInjecao = tipoInjecao;
        this.ramoMolde = ramoMolde;
        this.componentes = componentes;
    }

    public EnumTipoInjecao getTipoInjecao() {
        return tipoInjecao;
    }

    public void setTipoInjecao(EnumTipoInjecao tipoInjecao) {
        this.tipoInjecao = tipoInjecao;
    }

    public EnumRamoProduto getRamoMolde() {
        return ramoMolde;
    }

    public void setRamoMolde(EnumRamoProduto ramoMolde) {
        this.ramoMolde = ramoMolde;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
