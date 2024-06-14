package kuboys.gestProd.models;

import kuboys.gestProd.enums.EnumRamoProduto;
import kuboys.gestProd.enums.EnumTipoInjecao;

import java.util.ArrayList;
import java.util.List;

public class Molde extends Produto{

    private EnumTipoInjecao tipoInjecao;
    private EnumRamoProduto ramoMolde;
    private List<Componente> componentes;

    public Molde() {
        super();
        this.tipoInjecao = null;
        this.ramoMolde = null;
        this.componentes = new ArrayList<>();
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
