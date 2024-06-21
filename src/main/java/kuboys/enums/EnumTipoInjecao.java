package kuboys.enums;

public enum EnumTipoInjecao {

    ALUMINIO("AL", "Alumínio"),
    BORRACHA("BO", "Borracha"),
    PLASTICO("PL", "Plástico");

    private String codigo;
    private String descricao;

    EnumTipoInjecao(String codigo, String descricao) {
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

    public static EnumTipoInjecao getPorCodigo(String codigo) {
        for (EnumTipoInjecao tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
