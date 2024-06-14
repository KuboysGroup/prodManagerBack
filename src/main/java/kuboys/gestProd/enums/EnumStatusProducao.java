package kuboys.gestProd.enums;

public enum EnumStatusProducao {

    USINAGEM("US", "Em processo de usinagem"),
    MONTAGEM("MO", "Em processo de montagem"),
    POLIMENTO("PO", "Em processo de polimento"),
    FECHAMENTO("FE", "Em processo de fechamento"),
    TRATAMENTO_TERMICO("TT", "Em processo de tratamento térmico"),
    REVESTIMENTO("RE", "Em processo de revestimento"),
    FINALIZADO("FI", "Produção finalizada");

    private String codigo;
    private String descricao;

    EnumStatusProducao(String codigo, String descricao) {
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

    public static EnumStatusProducao getPorCodigo(String codigo) {
        for (EnumStatusProducao tipo : values()) {
            if (tipo.codigo.equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
