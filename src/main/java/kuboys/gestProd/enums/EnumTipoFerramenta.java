package kuboys.gestProd.enums;

public enum EnumTipoFerramenta {

    BITS("BI", "Bits"),
    BROCA("BR", "Broca"),
    CABECOTE("CB", "Cabeçote"),
    FRESA("FR", "Fresa"),
    INSERTO("IN", "Insertos");

    private String codigo;
    private String descricao;

    EnumTipoFerramenta(String codigo, String descricao) {
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

    public static EnumTipoFerramenta getPorCodigo(String codigo) {
        for (EnumTipoFerramenta tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
