package kuboys.enums;

public enum EnumRamoProduto {

    AUTOMOTIVO("AU", "Automotivo"),
    FUNDICAO("FU", "Fundição"),
    LINHA_BRANCA("LB", "Linha Branca");

    private String codigo;
    private String descricao;

    EnumRamoProduto(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EnumRamoProduto getPorCodigo(String codigo) {
        for (EnumRamoProduto tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
